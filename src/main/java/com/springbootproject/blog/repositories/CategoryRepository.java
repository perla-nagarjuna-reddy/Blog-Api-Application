package com.springbootproject.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
