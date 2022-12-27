package com.proj.blog.service;

import java.util.List;

import com.proj.blog.payloads.CategoryDto;

public interface CategoryService {
	
	 
	 CategoryDto createCategory(CategoryDto categoryDto);
	 
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer category_id);
	 
	 void deleteCategory(Integer Category_id);
	 
	 CategoryDto getCategory(Integer category_id);
	 
	 List<CategoryDto> getCategories();

	

}
