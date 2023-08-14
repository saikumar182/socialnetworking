package com.example.SocialNetwork.service;

//import com.example.SocialNetwork.entity.Follow;
import com.example.SocialNetwork.entity.Follow;
import com.example.SocialNetwork.entity.Post;
import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.exception.ResourceNotFoundException;
//import com.example.SocialNetwork.repository.FollowRepository;
import com.example.SocialNetwork.repository.FollowRepository;
import com.example.SocialNetwork.repository.PostRepository;
import com.example.SocialNetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FollowRepository followRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + userId));
    }


    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }


    public List<User> getFollowersForSimilarUsername(String username) {
        List<User> followers = new ArrayList<>();
        List<User> users = userRepository.findByUsernameContainingIgnoreCase(username);

        for (User user : users) {
            List<Follow> followings = followRepository.findByFollowed(user);
            followers.addAll(followings.stream().map(Follow::getFollower).collect(Collectors.toList()));
        }

        return followers;
    }

}