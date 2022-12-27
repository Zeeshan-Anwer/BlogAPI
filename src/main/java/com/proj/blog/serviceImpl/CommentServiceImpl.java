package com.proj.blog.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.blog.entities.Comment;
import com.proj.blog.entities.Post;
import com.proj.blog.payloads.CommentDto;
import com.proj.blog.repository.CommentRepo;
import com.proj.blog.repository.PostRepo;
import com.proj.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	PostRepo postRepo;

	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

	Post post=postRepo.findById(postId).orElseThrow();
	Comment comment=this.modelMapper.map(commentDto, Comment.class);
	comment.setPost(post);
	Comment savedCom=commentRepo.save(comment);
	
		return this.modelMapper.map(savedCom, CommentDto.class) ;
	}

	@Override
	public void deleteComment(Integer commentid) {
		
		Comment com=commentRepo.findById(commentid).orElse(null);
		commentRepo.deleteById(commentid);
		
	}
	
	

}
