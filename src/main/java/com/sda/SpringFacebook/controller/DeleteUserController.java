package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public void deleteUser(@RequestParam String id){
        deleteUserService.deleteUser(userRepository.findOne(id));
    }
}
