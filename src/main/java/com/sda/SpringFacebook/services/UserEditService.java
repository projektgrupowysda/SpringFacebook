package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserEditService {

    void changeUserDataById (User userToChange);

}
