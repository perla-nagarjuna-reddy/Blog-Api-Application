package com.springbootproject.blog.services.impl;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.blog.entities.Category;
import com.springbootproject.blog.exceptions.ResourceNotFoundException;
import com.springbootproject.blog.payloads.CategoryDto;
import com.springbootproject.blog.repositories.CategoryRepository;
import com.springbootproject.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat= this.modelMapper.map(categoryDto, Category.class);
		Category addedCat= this.categoryRepository.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepository.save(category);
		
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		this.categoryRepository.delete(category);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
	    Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
	
	    return this.modelMapper.map(category,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryRepository.findAll();
		
		List<CategoryDto> categoryDtos = categories.stream().map((cat) -> this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}

}
