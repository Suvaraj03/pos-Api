package com.pointOfSale.suvaraj.project1.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.pointOfSale.suvaraj.project1.auth.service.JwtService;
import com.pointOfSale.suvaraj.project1.auth.service.MyJWTFilter;
import com.pointOfSale.suvaraj.project1.auth.service.MyUserDetailsService;

import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MyUserDetailsService myUserDetailService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.cors(t ->{})
				.csrf(csrf->csrf.disable())
				.addFilterBefore(new MyJWTFilter(jwtService), BasicAuthenticationFilter.class)
				//.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.authorizeHttpRequests(request->request.requestMatchers("/user/register","user/login").permitAll().anyRequest().authenticated())
				.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails user1 = User.withDefaultPasswordEncoder()
//								.username("rohith")
//								.password("rohith123")
//								.build();
//		
//	return new InMemoryUserDetailsManager(user1);
//	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(myUserDetailService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		
		return http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(authenticationProvider())
				.build();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}
