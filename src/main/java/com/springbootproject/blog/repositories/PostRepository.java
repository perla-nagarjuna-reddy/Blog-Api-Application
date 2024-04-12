package com.springbootproject.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.blog.entities.Category;
import com.springbootproject.blog.entities.Post;
import com.springbootproject.blog.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);

}
