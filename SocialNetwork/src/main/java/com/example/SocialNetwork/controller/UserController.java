package com.example.SocialNetwork.controller;

import com.example.SocialNetwork.entity.Follow;
import com.example.SocialNetwork.entity.Post;
import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.service.FollowService;
import com.example.SocialNetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired

    private UserService userService;

    @Autowired
    private FollowService followService;


    @GetMapping("/{userId}/follower-posts")
    public ResponseEntity<?> getFollowerPosts(@PathVariable Long userId) {
        User user = userService.findById(userId);
        List<Follow> followerRelations = followService.findByFollowed(user);

        List<User> followers = followerRelations.stream()
                .map(Follow::getFollower)
                .collect(Collectors.toList());

        List<Post> followerPosts = followers.stream()
                .flatMap(follower -> follower.getPost().stream())
                .collect(Collectors.toList());

        if (followerPosts.isEmpty()) {
            return ResponseEntity.ok("No posts available from followers.");
        }

        return ResponseEntity.ok(followerPosts);
    }

}