package com.proj.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.blog.entities.Category;
import com.proj.blog.exceptions.ResourceNotFoundException;
import com.proj.blog.payloads.CategoryDto;
import com.proj.blog.repository.CategoryRepo;
import com.proj.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category savedCat=categoryRepo.save(cat);
		return this.modelMapper.map(savedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer category_id) {
		
			Category category=categoryRepo.findById(category_id).orElseThrow( 
					()-> new ResourceNotFoundException("category","category_id",category_id));
			
			category.setCategory_Description(categoryDto.getCategory_Description());
			category.setCategory_Title(categoryDto.getCategory_Title());
			
			Category updatedCat=this.categoryRepo.save(category);
			
			return this.modelMapper.map(updatedCat, CategoryDto.class);
		
	}

	@Override
	public void deleteCategory(Integer category_id) {
		
		Category cat=this.categoryRepo.findById(category_id).orElseThrow(
				()-> new ResourceNotFoundException("category","category_id",category_id));
			
		this.categoryRepo.delete(cat);
		
		
		
		
	}

	@Override
	public CategoryDto getCategory(Integer category_id) {

		Category category=this.categoryRepo.findById(category_id).orElseThrow(
				()->new ResourceNotFoundException("category", "category_id",category_id));
		
		return this.modelMapper.map(category, CategoryDto.class);
		
		
		
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		
		List<Category> catogeries=categoryRepo.findAll();
		
		List<CategoryDto> catDtos=catogeries.stream().map((i) -> this.modelMapper.map(i,CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}
	

}
