package com.example.SocialNetwork.controller;

import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.service.FollowService;
import com.example.SocialNetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class FollowController{


    @Autowired
    private UserService userService;
    @Autowired
    private FollowService followService;
    @GetMapping("/{username}/followers")
    public ResponseEntity<List<User>> getFollowersForUser(@PathVariable String username) {
        User user = userService.findByUsername(username);
        List<User> followers = followService.getFollowersForUser(user);
        return ResponseEntity.ok(followers);
    }

}
