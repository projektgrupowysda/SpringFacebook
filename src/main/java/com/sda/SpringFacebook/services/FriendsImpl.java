package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        user.getFriends().add(userByIdToAdd.getId());
        userRepository.save(user);

        userByIdToAdd.getFriends().add(user.getId());
        userRepository.save(userByIdToAdd);
    }

    @Override
    public void removeFriend(String userId, String userToDelId) {

        User user = userRepository.findById(userId);
        User userToDel = userRepository.findById(userToDelId);

        if (user == null && userToDel == null ){
            throw new RuntimeException("Nie ma takich użytkowników o id :" + userId + " oraz " + userToDelId);
        }else if (userToDel == null){
            throw new RuntimeException("Nie ma użytkownika o id: " + userToDelId);
        }else if (user == null){
            throw new RuntimeException("Nie ma użytkownika o id: " + userId);
        }

        if (user.getFriends()==null || user.getFriends().isEmpty()){
            throw new RuntimeException(user.getFirstName() + ". Ty Nie masz żadnych znajomych.");
        }

        user.getFriends().remove(userToDel.getId());
        userRepository.save(user);
        userToDel.getFriends().remove(user.getId());
        userRepository.save(userToDel);
    }

    @Override
    public List<User> getAllFriends(String id) {

        User user = userRepository.findById(id);

        if (user == null) {

            throw new RuntimeException("Brak użytkownika");
        }

        if (user.getFriends().isEmpty()) {

            throw new RuntimeException("Brak znajmoeych");
        }

       return user.getFriends().stream()
                .map(userId -> userRepository.findById(userId))
                .collect(Collectors.toList());

    }


}
