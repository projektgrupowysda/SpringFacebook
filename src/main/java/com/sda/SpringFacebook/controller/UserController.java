package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.CreateUserRequest;
import com.sda.SpringFacebook.request.UpdateUserRequest;
import com.sda.SpringFacebook.services.CreatingUserService;
import com.sda.SpringFacebook.services.DeleteUserService;
import com.sda.SpringFacebook.services.UserEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private CreatingUserService creatingUserService;
    private UserRepository userRepository;
    private DeleteUserService deleteUserService;
    private UserEditService userEditService;

    @Autowired

    public UserController(CreatingUserService creatingUserService, UserRepository userRepository, DeleteUserService deleteUserService, UserEditService userEditService) {
        this.creatingUserService = creatingUserService;
        this.userRepository = userRepository;
        this.deleteUserService = deleteUserService;
        this.userEditService = userEditService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody CreateUserRequest request) {

        creatingUserService.createPerson(request);
    }

    @PostMapping("/deleteuser")
    public void deleteUser(@RequestParam String id){
        deleteUserService.deleteUser(userRepository.findOne(id));

    }

    @PostMapping("/edit/{userId}")
    public void createPerson(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        userEditService.changeUserDataById(request, userId);
    }

    @GetMapping("/all")
    public Page<User> findByLogin(@PageableDefault(size = 10) Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
