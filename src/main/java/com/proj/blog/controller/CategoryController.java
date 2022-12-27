package com.proj.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.blog.payloads.ApiResponse;
import com.proj.blog.payloads.CategoryDto;
import com.proj.blog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService catService;
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCat(@Valid @RequestBody CategoryDto catDto){
		
		CategoryDto createdCat=this.catService.createCategory(catDto);
		return new ResponseEntity<>(createdCat,HttpStatus.CREATED);
		
	}
	

	@PutMapping("/{id}")
	
	public ResponseEntity<CategoryDto> updateCat(@Valid @RequestBody CategoryDto catDto,@PathVariable Integer id){
		
		CategoryDto updateCat=this.catService.updateCategory(catDto,id);
		return new ResponseEntity<>(updateCat,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id){
		
		this.catService.deleteCategory(id);
		return new ResponseEntity<>(new ApiResponse("User Successfully Deleted",true),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id){
		
		CategoryDto category=this.catService.getCategory(id);
		
		
		return new ResponseEntity<>(category,HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		
		List<CategoryDto> categories=this.catService.getCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);

	}


}
