package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.model.User;

import java.util.List;

public interface FriendsService {

    void addToFriends(String userToAddId, String userId);

    List<User> getAllFriends(String id);
}
