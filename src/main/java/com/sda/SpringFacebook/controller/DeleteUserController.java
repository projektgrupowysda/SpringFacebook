package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteUserController {

    private UserRepository userRepository;
    private DeleteUserService deleteUserService;

    @Autowired
    public DeleteUserController(UserRepository userRepository, DeleteUserService deleteUserService) {
        this.userRepository = userRepository;
        this.deleteUserService = deleteUserService;
    }


    @RequestMapping("/deleteuser")
    public void deleteUser(User user){
        deleteUserService.deleteUser(user);
    }
}
