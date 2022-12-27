package com.proj.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.blog.entities.Category;
import com.proj.blog.entities.Post;
import com.proj.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer> {
	
	List<Post> 	findByUser(User user);
	
	List<Post>	findByCategory(Category category);
	
	List<Post> findByTitleContaining(String keyword);
	
	List<Post> findByStatus(String status);
}
