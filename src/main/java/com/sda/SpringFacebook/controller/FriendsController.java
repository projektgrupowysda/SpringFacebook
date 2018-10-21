package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.services.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendsController {

    FriendsService friendsService;

    @Autowired
    public FriendsController(FriendsService friendsService) {

        this.friendsService = friendsService;
    }

    @PutMapping("/{userId}/addFriend/{userToAddId}")
    public void addToFriend(@PathVariable String userToAddId, @PathVariable String userId) {

        friendsService.addToFriends(userToAddId, userId);
    }

    @GetMapping("/{id}/showAllFriends")
    public List<User> getAllFriends(@PathVariable String id) {

        return friendsService.getAllFriends(id);
    }

    @DeleteMapping("/{userId}/removeFriend/{userToDelId}")
    public void removeFriend(@PathVariable String userId, @PathVariable String userToDelId) {

        friendsService.removeFriend(userId, userToDelId);
    }



}
