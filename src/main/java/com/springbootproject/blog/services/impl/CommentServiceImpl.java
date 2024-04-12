package com.springbootproject.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.blog.entities.Comment;
import com.springbootproject.blog.entities.Post;
import com.springbootproject.blog.exceptions.ResourceNotFoundException;
import com.springbootproject.blog.payloads.CommentDto;
import com.springbootproject.blog.repositories.CommentRepository;
import com.springbootproject.blog.repositories.PostRepository;
import com.springbootproject.blog.services.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","Post Id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComment = this.commentRepository.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment comment  = this.commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","Comment Id", commentId));
		
		this.commentRepository.delete(comment);
	}

}
