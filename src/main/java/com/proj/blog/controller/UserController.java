package com.proj.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.blog.payloads.ApiResponse;
import com.proj.blog.payloads.UserDto;
import com.proj.blog.service.UserServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	
	
	@Autowired
	UserServices userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		UserDto createdUser=this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUser,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer id){
		UserDto updatedUser=userService.updateUser(userDto, id);
		return ResponseEntity.ok(updatedUser);
	}
		

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
		
		userService.deleteUser(id); 
		return new ResponseEntity(new ApiResponse("User Successfully Deleted",true),HttpStatus.OK);

}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer user_id){
		
		UserDto user=userService.getUserById(user_id);
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getAllUsers(){
//		log.error("Print error");
//		log.debug("Print debug");
		
//		
		return  ResponseEntity.ok(userService.getAllUsers());
	}
}
	
	
