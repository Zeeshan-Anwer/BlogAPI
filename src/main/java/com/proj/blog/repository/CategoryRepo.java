package com.proj.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.blog.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {


	
	

}
