package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.dto.UserDto;
import com.pointOfSale.suvaraj.project1.entity.User;

public interface IUserService {
	public UserDto addUser(User user);
	//public User addCountries(List<E>);
	public User getUser(long id);
	public List<User> getUsers();
	public User updateUser(long id,User user);
	public String  deleteUser(long id);

}
