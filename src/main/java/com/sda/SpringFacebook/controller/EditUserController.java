package com.sda.SpringFacebook.controller;


import com.sda.SpringFacebook.request.UpdateUserRequest;
import com.sda.SpringFacebook.services.UserEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditUserController {

    private UserEditService userEditService;

    @Autowired
    public EditUserController(UserEditService userEditService) {
        this.userEditService = userEditService;
    }

    @PostMapping("/edit/{userId}")
    public void createPerson(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        userEditService.changeUserDataById(request, userId);
    }
}

