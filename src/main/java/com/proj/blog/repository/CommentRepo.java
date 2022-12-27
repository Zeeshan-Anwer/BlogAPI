package com.proj.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

}
