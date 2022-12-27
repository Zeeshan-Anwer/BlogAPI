package com.proj.blog.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.proj.blog.entities.Category;
import com.proj.blog.entities.Post;
import com.proj.blog.entities.User;
import com.proj.blog.exceptions.ResourceNotFoundException;
import com.proj.blog.payloads.ApiResponse;
import com.proj.blog.payloads.PostDto;
import com.proj.blog.payloads.PostResponse;
import com.proj.blog.repository.CategoryRepo;
import com.proj.blog.repository.PostRepo;
import com.proj.blog.repository.UserRepo;
import com.proj.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CategoryRepo categoryRepo;

	//public PostDto createPost(PostDto postDto,Integer user_id,Category category_id);
	
	@Override
	public PostDto createPost(PostDto postDto,Integer user_id,Integer category_id) {
		
		User user=this.userRepo.findById(user_id).orElseThrow(
				()->new ResourceNotFoundException("user","user_id",user_id));
		
		Category category=this.categoryRepo.findById(category_id).orElseThrow(
				()-> new ResourceNotFoundException("category","category",category_id));
		
		
		
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		post.setImageName("default.png");
		
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
		
	}



	@Override
	@PutMapping("/deltete/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("post","post",postId));
		
		this.postRepo.delete(post);
		return new ApiResponse("Post Successfully deleted",true);
		
	}

	@Override
	public PostResponse getAllPost(Integer pageno,Integer pagesize,String sortBy) {
		
		Pageable p=PageRequest.of(pageno, pagesize, Sort.by(sortBy));
		
		

		Page<Post> Pageposts=this.postRepo.findAll(p);
		
		List<Post> allPosts=Pageposts.getContent();
		
		List<PostDto> postsDto=allPosts.stream().map( (post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList()); 
		
		PostResponse res=new PostResponse();
		res.setContent(postsDto);
		res.setLastPage(Pageposts.isLast());
		res.setPageNumber(Pageposts.getNumber());
		res.setTotalElements(Pageposts.getTotalElements());
		res.setTotalPages(Pageposts.getTotalPages());
		res.setPageSize(Pageposts.getSize());
		
		return res;
		
	}
	
	

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("post","post",postId));
		
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryid,Integer pageno,Integer pagesize,String sortBy) {
		
		Category cat=this.categoryRepo.findById(categoryid).orElseThrow(()->
				new ResourceNotFoundException("Post","categoryid",categoryid));
		
//		Pageable p=PageRequest.of(pageno, pagesize, Sort.by(sortBy));
//		Page<Post> Pageposts=this.postRepo.findAll(p);
//		List<Post> allPosts=Pageposts.getContent();
//		List<PostDto> postsDto=allPosts.stream().map( (post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList()); 
//		List<Post> posts=this.postRepo.findByCategory(cat);
//		
		Pageable p=PageRequest.of(pageno, pagesize, Sort.by(sortBy));
		Page post=this.postRepo.findAll(p);
		List<Post> posts=post.getContent();
		
		
		List<PostDto> postsDto=posts.stream().map((po)-> this.modelMapper.map(po, PostDto.class)).collect(Collectors.toList());
		
		return postsDto;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("user","user_id",userId));
		
		List<Post> posts=this.postRepo.findByUser(user);
		
		List<PostDto> postsDto=posts.stream().map( (i)-> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postsDto;
	}

	@Override
	public List<PostDto> searchPost(String Keyword) {
		
	
		
		List<Post> posts=this.postRepo.findByTitleContaining(Keyword);
		List<PostDto> dtoPosts=posts.stream().map((i)->this.modelMapper.map(i, PostDto.class)).collect(Collectors.toList());
		return dtoPosts;
	}

	@Override
	public PostDto updatePost(PostDto postDto,Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("post","post",postId));
		
		
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		post.setTitle(postDto.getTitle());
		
		Post savePost=this.postRepo.save(post);
		return this.modelMapper.map(savePost, PostDto.class);
	}
	
	@Override
	public List<Post> getPostByStatus(String status) {
		
		
		List<Post> posts=this.postRepo.findByStatus(status);
		
		//List<PostDto> postsDto=posts.stream().map( (i)-> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return posts;
	}

}
