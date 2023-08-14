package com.example.SocialNetwork.repository;

import com.example.SocialNetwork.entity.Follow;
import com.example.SocialNetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {


    List<Follow> findByFollowed(User followed);
    List<Follow> findByFollower(User follower);
}
