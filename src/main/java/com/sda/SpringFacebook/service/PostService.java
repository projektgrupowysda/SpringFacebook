package com.sda.SpringFacebook.service;

import com.sda.SpringFacebook.database.PostRepository;
import com.sda.SpringFacebook.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public PostService(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


}
