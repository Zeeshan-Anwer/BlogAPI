package com.proj.blog.controller;

import java.util.List;

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

import com.proj.blog.entities.Post;
import com.proj.blog.payloads.ApiResponse;
import com.proj.blog.payloads.PostDto;
import com.proj.blog.payloads.PostResponse;
import com.proj.blog.service.PostService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/")
@Slf4j
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{user_id}/category/{category_id}/post")
	public ResponseEntity<PostDto> createPost( @RequestBody PostDto postDto,
			@PathVariable Integer user_id,@PathVariable Integer category_id){
		
		PostDto newPost=this.postService.createPost(postDto,user_id, category_id);
		
		return new ResponseEntity<>(newPost,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/user/{user_id}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer user_id){
		
		List<PostDto> posts=this.postService.getPostByUser(user_id);
		
		return new ResponseEntity<>(posts,HttpStatus.OK);
		
	}
	
	@GetMapping("categories")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer category_id,
			@RequestParam( value="pageno",defaultValue="1",required=false)Integer pageno,
			@RequestParam(value="pagesize",defaultValue="5",required=false)Integer pagesize,
			@RequestParam( value="category_Id",defaultValue="category_Id",required=false) String sortBy)
	{
		
		List<PostDto> catogeries=this.postService.getPostByCategory(category_id,pageno,pagesize,sortBy);
	
		return new ResponseEntity<>(catogeries,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value="pagesize",defaultValue="5",required=false) Integer pagesize,
			@RequestParam(value="pageno",defaultValue="1",required=false) Integer pageno,
			@RequestParam(value="sort",defaultValue="postId",required=false) String sortBy)
	{
		
		 PostResponse res=this.postService.getAllPost(pageno,pagesize,sortBy);
		 return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	//getPostDetailsById
	
	@GetMapping("/{id}/post")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer id){
		
		PostDto posts=this.postService.getPostById(id);
		
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{postid}")
	public ResponseEntity<PostDto> updatedPost(@PathVariable Integer postid,PostDto postDto){
		
		PostDto posts=this.postService.updatePost(postDto, postid);
		
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteById(@PathVariable Integer postid){
		
		this.postService.deletePost(postid);

		return new ApiResponse("Post Successfully Deleted",true);
	}
	
	@GetMapping("/")
	public void get() {
		log.debug("Debug enabled");
		log.error("Hi, I am error");
	}

	
	@GetMapping("/getAllStatus")
	public ResponseEntity<?> getAllPost(
			@RequestParam(value="status",required=true) String status){
		
		 List<Post> posts=this.postService.getPostByStatus(status);
		 return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
}
