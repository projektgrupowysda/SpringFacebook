package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.CreateUserRequest;
import com.sda.SpringFacebook.request.UpdateUserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void createPerson(CreateUserRequest request);

    void deleteUser(User user);

    Page<User> getAllUsers(Pageable pageable);

    void changeUserDataById(UpdateUserRequest request, String userId);

    Page<User> getAllByPhrase(String phrase, Pageable pageable);
}
