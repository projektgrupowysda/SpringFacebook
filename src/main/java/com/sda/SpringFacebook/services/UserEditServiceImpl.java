package com.sda.SpringFacebook.services;


import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEditServiceImpl implements UserEditService {

    private UserRepository user;

    @Autowired
    public UserEditServiceImpl(UserRepository user) {
        this.user = user;
    }

    @Override
    public void changeUserDataById(UpdateUserRequest request, String userId) {
        User userToChange= user.findById(userId);

        userToChange.setFirstName(request.getFirstName());
        userToChange.setLastName(request.getLastName());
        userToChange.setPassword(request.getPassword());

        user.save(userToChange);
    }
}
