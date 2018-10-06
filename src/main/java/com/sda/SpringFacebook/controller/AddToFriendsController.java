package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.services.AddToFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddToFriendsController {

    AddToFriendsService addToFriendsService;

    @Autowired
    public AddToFriendsController(AddToFriendsService addToFriendsService) {
        this.addToFriendsService = addToFriendsService;
    }

    @GetMapping("/addFriend")
    public void addToFriend(@RequestParam String userToAddId, @RequestParam String userId) {

        addToFriendsService.addToFriends(userToAddId, userId);
    }
}
