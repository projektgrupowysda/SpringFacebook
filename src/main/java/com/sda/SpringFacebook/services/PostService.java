package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.model.Post;
import com.sda.SpringFacebook.request.CreatePostRequest;

import java.util.List;

public interface PostService {

    void createPost(CreatePostRequest request);

    List<Post> viewPostsYouAreTheAuthor();

    List<Post> viewAllPublicPostAndAllPostFriends();

    void deletePost(String id);

    void addLike(String id);

    void editPost(String id, String content);

}
