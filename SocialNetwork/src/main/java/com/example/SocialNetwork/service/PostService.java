package com.example.SocialNetwork.service;

import com.example.SocialNetwork.entity.Like;
import com.example.SocialNetwork.entity.Post;
import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.exception.ResourceNotFoundException;
import com.example.SocialNetwork.repository.LikeRepository;
import com.example.SocialNetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired

    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
    }


    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
}


