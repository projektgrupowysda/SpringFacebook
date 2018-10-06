package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.services.DeleteUserService;
import com.sda.SpringFacebook.services.UserEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
public class DeleteUserController {

    private UserRepository userRepository;
    private DeleteUserService deleteUserService;
    private UserEditService userEditService;

    @Autowired
    public DeleteUserController(UserRepository userRepository, DeleteUserService deleteUserService, UserEditService userEditService) {
        this.userRepository = userRepository;
        this.deleteUserService = deleteUserService;
        this.userEditService = userEditService;
    }

    @RequestMapping("/deleteuser")
    public void deleteUser(User user) {
        deleteUserService.deleteUser(user);
    }

    @PostMapping(value = "/editUser")
    public void editUser(@RequestBody User user) {
        userEditService.changeUserDataById(user);

    }
}
