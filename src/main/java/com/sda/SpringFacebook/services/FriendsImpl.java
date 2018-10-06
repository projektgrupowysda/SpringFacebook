package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsImpl implements FriendsService {

    UserRepository userRepository;

    @Autowired
    public FriendsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addToFriends(String userToAddId, String userId) {

        User userByIdToAdd = userRepository.findById(userToAddId);
        User user = userRepository.findById(userId);

        if (userByIdToAdd == null || user == null) {

            throw new RuntimeException("Nie ma takiego użytkownika");
        }

        user.getFriends().add(userByIdToAdd);
        userRepository.save(user);
        userByIdToAdd.getFriends().add(user);
        userRepository.save(userByIdToAdd);
    }

    @Override
    public List<User> getAllFriends(String id) {

        User user = userRepository.findById(id);

        if (user == null) {

            throw new RuntimeException("Brak użytkownika");
        }

        if (user.getFriends().size() == 0) {

            throw new RuntimeException("Brak znajmoeych");
        }
        return user.getFriends();
    }


}
