package com.sda.SpringFacebook.services;


import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEditServiceImpl implements UserEditService {

    private UserRepository userRepository;

    @Autowired
    public UserEditServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void changeUserDataById(User userToChange) {
        User userChanged;
        userChanged = userRepository.findById(userToChange.getId());

        userChanged.setLogin(userChanged.getLogin());
        userChanged.setFirstName(userChanged.getFirstName());
        userChanged.setLastName(userChanged.getLastName());
        userChanged.setPassword(userChanged.getPassword());

        userRepository.save(userChanged);
    }

}
