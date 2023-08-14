package com.example.SocialNetwork.controller;

import com.example.SocialNetwork.entity.*;
import com.example.SocialNetwork.service.CommentService;
import com.example.SocialNetwork.service.PostService;
import com.example.SocialNetwork.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @Autowired

    private UserService userService;




    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addCommentToPost(
            @RequestParam Long userId,
            @RequestParam Long postId,
            @RequestBody String content) {

        User user = userService.findById(userId);
        Post post = postService.findById(postId);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);

        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }


}
