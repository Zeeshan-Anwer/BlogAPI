package com.proj.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	

}
