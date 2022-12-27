package com.proj.blog.service;

import com.proj.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer PostId);
	
	void deleteComment(Integer commentid);
	
}
