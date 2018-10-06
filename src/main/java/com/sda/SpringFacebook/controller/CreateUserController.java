package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.request.CreateUserRequest;
import com.sda.SpringFacebook.services.CreatingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    private CreatingUserService creatingUserService;

    @Autowired
    public CreateUserController(CreatingUserService creatingUserService) {
        this.creatingUserService = creatingUserService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody CreateUserRequest request) {

        creatingUserService.createPerson(request);
    }
}
