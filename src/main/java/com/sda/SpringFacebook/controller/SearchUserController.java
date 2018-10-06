package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchUserController {
    private UserRepository userRepository;

    @Autowired
    public SearchUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public Page<User> findByLogin(@PageableDefault(size = 2) Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
