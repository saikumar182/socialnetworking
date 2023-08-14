package com.example.SocialNetwork.service;

import com.example.SocialNetwork.entity.Comment;
//import com.example.SocialNetwork.entity.CommentRequest;
import com.example.SocialNetwork.entity.Post;
import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.exception.ResourceNotFoundException;
import com.example.SocialNetwork.repository.CommentRepository;
import com.example.SocialNetwork.repository.PostRepository;
import com.example.SocialNetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {


    @Autowired

    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}

