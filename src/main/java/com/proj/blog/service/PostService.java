package com.proj.blog.service;

import java.util.List;

import com.proj.blog.entities.Post;
import com.proj.blog.payloads.ApiResponse;
import com.proj.blog.payloads.PostDto;
import com.proj.blog.payloads.PostResponse;

public interface PostService {
	
	public PostDto createPost(PostDto postDto,Integer user_id,Integer category_id);
	
	public PostDto updatePost(PostDto postDto,Integer postId);
	
	public ApiResponse deletePost(Integer postid);
	
	public PostResponse getAllPost(Integer pageno,Integer pagesize,String soryBy);
	
	public PostDto getPostById(Integer postId);
	
	List<Post> getPostByStatus(String status);
	
	
	//Pagination
	List<PostDto> getPostByCategory(Integer categoryid,Integer pageno,Integer pagesize,String sortBy);

	// Pagination
	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> searchPost(String Keyword);
	
	
}
