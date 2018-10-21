package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.CreateUserRequest;
import com.sda.SpringFacebook.request.UpdateUserRequest;
import com.sda.SpringFacebook.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController {

    private UserRepository userRepository;
    private UserService userService;


    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody @Valid CreateUserRequest request) {

        userService.createPerson(request);
    }

    @DeleteMapping("/deleteuser")
    public void deleteUser(@RequestParam String id){
        userService.deleteUser(userRepository.findOne(id));

    }

    @PutMapping("/edit/{userId}")
    public void createPerson(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        userService.changeUserDataById(request, userId);
    }

    @GetMapping("/all")
    public Page<User> findByLogin(@PageableDefault(size = 10) Pageable pageable){
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/search/{phrase}")
    public Page<User> findByPhrase (@PathVariable String phrase,
                                    @PageableDefault(size = 10) Pageable pageable){
        return userService.getAllByPhrase(phrase, pageable);
    }


}
