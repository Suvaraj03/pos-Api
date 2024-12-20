package com.pointOfSale.suvaraj.project1.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pointOfSale.suvaraj.project1.entity.User;

@Mapper(componentModel = "spring")

public interface UserMapper {
	
	UserDto toUserDTO(User user);
}
