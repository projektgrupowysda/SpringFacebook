package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeleteUserService {

    private UserRepository userRepository;

    @Autowired
    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
