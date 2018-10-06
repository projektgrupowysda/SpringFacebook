package com.sda.SpringFacebook.service;

import com.sda.SpringFacebook.database.PostRepository;
import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.model.Post;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PostService {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public PostService(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void createPost(CreatePostRequest request){
        User user = getUserLoggedInFromRepository();

        Post post = Post.builder()
                .postContent(request.getPostContent())
                .userId(user.getId())
                .date(LocalDate.now())
                .time(LocalTime.now())
                .build();

        postRepository.save(post);

    }



    private User getUserLoggedInFromRepository(){
        return userRepository.findAll().stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(UserContextHolder.getUserLoggedIn()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Użytkownik " + UserContextHolder.getUserLoggedIn() + " nie istnieje"));
    }
}
