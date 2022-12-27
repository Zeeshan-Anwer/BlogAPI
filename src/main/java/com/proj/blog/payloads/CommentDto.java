package com.proj.blog.payloads;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.proj.blog.entities.Comment;
import com.proj.blog.entities.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

public class CommentDto {
	
	
	@Data
	@NoArgsConstructor

	public class Comment {
		
		private int id;
		
		private String content;
		
	
		private Post post;
		

	}


}
