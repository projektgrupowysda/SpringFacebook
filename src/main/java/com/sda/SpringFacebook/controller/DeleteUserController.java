package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserController {

    private UserRepository userRepository;
    private DeleteUserService deleteUserService;

    @Autowired
    public DeleteUserController(UserRepository userRepository, DeleteUserService deleteUserService) {
        this.userRepository = userRepository;
        this.deleteUserService = deleteUserService;
    }
    
    @PostMapping("/deleteuser")
    public void deleteUser(@RequestParam String id){
        deleteUserService.deleteUser(userRepository.findOne(id));

    }
}
