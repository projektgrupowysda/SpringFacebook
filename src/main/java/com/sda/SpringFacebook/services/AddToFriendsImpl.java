package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToFriendsImpl implements AddToFriendsService {

    UserRepository userRepository;

    @Autowired
    public AddToFriendsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addToFriends(String userToAddId, String userId) {

        User userByIdToAdd = userRepository.findById(userToAddId);
        User user = userRepository.findById(userId);

        if(userByIdToAdd == null || user == null){

            throw new RuntimeException("Nie ma takiego użytkownika");
        }

        List<User> friends = user.getFriends();
        friends.add(userByIdToAdd);

        userRepository.save(user);

        List<User> friends1 = userByIdToAdd.getFriends();
        friends1.add(user);

        userRepository.save(userByIdToAdd);
    }
}
