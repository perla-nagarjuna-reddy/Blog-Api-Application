package com.springbootproject.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.blog.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
