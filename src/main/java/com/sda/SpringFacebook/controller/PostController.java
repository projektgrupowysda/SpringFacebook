package com.sda.SpringFacebook.controller;

import com.sda.SpringFacebook.model.Post;
import com.sda.SpringFacebook.request.CreatePostRequest;
import com.sda.SpringFacebook.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody CreatePostRequest request) {
        postService.createPost(request);
    }

    @GetMapping("/viewPostsYouAreTheAuthor")
    public List<Post> viewPostsYouAreTheAuthor() {
        return postService.viewPostsYouAreTheAuthor();
    }

    @GetMapping("/viewAllPosts")
    public List<Post> viewAllPosts() {

        return postService.viewAllPublicPostAndAllPostFriends();
    }

    @PostMapping("/post/{postId}/addLike")
    public void addLike(@PathVariable String postId){
        postService.addLike(postId);
    }

    @PutMapping("/post/{postId}/editPost")
    public void editPost(@PathVariable String postId, @RequestBody String context){

        postService.editPost(postId, context);
    }


}
