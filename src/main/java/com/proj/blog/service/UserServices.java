package com.proj.blog.service;

import java.util.List;

import com.proj.blog.payloads.UserDto;

public interface UserServices {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer id);
	
	void deleteUser(Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUsers();

}
