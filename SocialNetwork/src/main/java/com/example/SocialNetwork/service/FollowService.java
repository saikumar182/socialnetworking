package com.example.SocialNetwork.service;

import com.example.SocialNetwork.entity.Follow;
import com.example.SocialNetwork.entity.User;
import com.example.SocialNetwork.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {

    @Autowired

    private FollowRepository followRepository;

    public List<User> getFollowersForUser(User user) {
        List<Follow> follows = followRepository.findByFollowed(user);
        return follows.stream().map(Follow::getFollower).collect(Collectors.toList());
    }
    public List<Follow> findByFollower(User follower) {
        return followRepository.findByFollower(follower);
    }

    public List<Follow> findByFollowed(User user) {
        return followRepository.findByFollowed(user);
    }
}
