package com.proj.blog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.proj.blog.repository.CategoryRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BlogApiApplication {
	


	
	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new  ModelMapper();
	}
}
