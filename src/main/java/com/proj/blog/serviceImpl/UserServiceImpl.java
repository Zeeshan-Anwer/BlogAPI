package com.proj.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.blog.entities.User;
import com.proj.blog.exceptions.ResourceNotFoundException;
import com.proj.blog.payloads.UserDto;
import com.proj.blog.repository.UserRepo;
import com.proj.blog.service.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(
				()->new ResourceNotFoundException("user","user_id",userId));
		
		user.setAbout(userdto.getAbout());
		user.setEmail_id(userdto.getEmail_id());
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		
		User updateUser =this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
		
	}

	@Override
	public void deleteUser(Integer id) {
		
		
		
		User deletedUser=this.userRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("user","id", id));
		
		this.userRepo.delete(deletedUser);
	}

	@Override
	public UserDto getUserById(Integer id) {
		
		User user=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
		return this.userToDto(user);
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		List<UserDto> usersDto=users.stream().map(i->this.userToDto(i)).collect(Collectors.toList());
		
		return usersDto;
	}
	
	private User dtoToUser(UserDto userDto) {
		User user=modelMapper.map(userDto,User.class);
//		user.setId(userDto.getId());
//		user.setAbout(userDto.getAbout());
//		user.setEmail_id(userDto.getEmail_id());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
//		 
				return user;
	}
	
	private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail_id(user.getEmail_id());
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
		return userDto;
		
	}

}
