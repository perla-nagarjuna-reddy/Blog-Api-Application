package com.springbootproject.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.blog.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
