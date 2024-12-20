package com.pointOfSale.suvaraj.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private long id;
	private String name;
	private String token;
	private String role;
	private String email;
	private String phone;
	

}
