package com.proj.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.blog.payloads.ApiResponse;
import com.proj.blog.payloads.CommentDto;
import com.proj.blog.service.CommentService;

@RestController
@RequestMapping("/api/comment")


	
public class CommentController {
	
	@Autowired
	CommentService commentService;	
	
	@PostMapping("/get/{id}")
	public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		
		CommentDto com=commentService.createComment(commentDto, postId);
		return new ResponseEntity<>(com,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		
		commentService.deleteComment(commentId);
		
		
		return new ResponseEntity<>(new ApiResponse("Comment Deleted Successfully",true),HttpStatus.OK);
	}
	

}
