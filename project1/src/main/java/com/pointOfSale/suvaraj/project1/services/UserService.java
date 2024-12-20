package com.pointOfSale.suvaraj.project1.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.auth.service.JwtService;
import com.pointOfSale.suvaraj.project1.dto.CredentialDto;
import com.pointOfSale.suvaraj.project1.dto.UserDto;
import com.pointOfSale.suvaraj.project1.dto.UserMapper;
import com.pointOfSale.suvaraj.project1.entity.User;
import com.pointOfSale.suvaraj.project1.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRepository repo;

	@Autowired
	private AuthenticationManager authManager;

	@Override
	public UserDto addUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userMapper.toUserDTO(repo.save(user));
		
		
		
	}

	@Override
	public User getUser(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<User> getUsers() {

		return repo.findAll();
	}

	@Override
	public User updateUser(long id, User user) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("User  ID is not found");
		} else {
			user.setId(id);
			addUser(user);
		}

		return user;
	}

	@Override
	public String deleteUser(long id) {
		repo.deleteById(id);
		return "User Desleted Succesfully";
	}

	public UserDto verify(CredentialDto credential) {
		// we need implement validation code

		Authentication authentication = authManager.authenticate
				(new UsernamePasswordAuthenticationToken(
				credential.email(), credential.password(), Collections.emptyList()));

		UserDto userDto = new UserDto();

		if (authentication.isAuthenticated()) {

			User user = repo.findByEmail(credential.email()).get();

			userDto = userMapper.toUserDTO(user);
			userDto.setToken(jwtService.createToken(user));
		}

		else {
			System.err.println("Fail");
		}

		return userDto;
	}

	public Optional<User> findByUserName(String email) {
		return repo.findByEmail(email);
	}
	
	
	
	

	public UserDto getProfile(String authToken) {

		String token = authToken.substring(7); // Remove the "Bearer " prefix
		
		
	

		String username = jwtService.getUsername(token);

		UserDto userDto = userMapper.toUserDTO(findByUserName(username).get());

		return userDto;

	}

}
