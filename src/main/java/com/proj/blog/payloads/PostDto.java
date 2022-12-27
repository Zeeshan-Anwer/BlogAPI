package com.proj.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.proj.blog.entities.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {
	
	private String title;
	private String status;
	
	private String content;
	
	private Integer postId;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
	

}
