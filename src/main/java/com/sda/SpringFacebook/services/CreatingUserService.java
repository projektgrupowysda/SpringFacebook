package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatingUserService {

    private UserRepository repository;

    @Autowired
    public CreatingUserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createPerson(CreateUserRequest request) {
        User person = User.builder()
                .login(request.getLogin())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .friends(request.getFriends())
                .build();

        repository.save(person);
    }
}
