package com.proj.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CategoryDto {

	
	private Integer category_Id;
	
	@NotBlank
	@Size(min=5 , message="5 Character is Must")
	private String category_Title;

	@NotBlank
	@Size(min=10,message="10 character is must")
	private String category_Description;
}


