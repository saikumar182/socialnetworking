package com.example.SocialNetwork.controller;
import com.example.SocialNetwork.entity.Post;
import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.service.LikeService;
import com.example.SocialNetwork.service.PostService;
import com.example.SocialNetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {


    @Autowired
    private PostService postService;
    @Autowired
    private LikeService likeService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Post> addPost(
            @RequestParam Long userId,
            @RequestBody String content) {

        User user = userService.findById(userId);

        Post post = new Post();
        post.setUser(user);
        post.setContent("Hello from " + user.getFirstName() + " " + user.getLastName() + "! " + content);

        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }
}
