package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.database.PostRepository;
import com.sda.SpringFacebook.database.UserRepository;
import com.sda.SpringFacebook.enums.RangeOfPost;
import com.sda.SpringFacebook.model.Post;
import com.sda.SpringFacebook.model.User;
import com.sda.SpringFacebook.request.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void createPost(CreatePostRequest request) {

        User user = getUserLoggedInFromRepository();

        Post post = Post.builder()
                .postContent(request.getPostContent())
                .userId(user.getId())
                .date(LocalDate.now())
                .time(LocalTime.now())
                .rangeOfPost(request.getRangeOfPost())
                .build();

        postRepository.save(post);
    }

    public List<Post> viewPostsYouAreTheAuthor() {

        User user = getUserLoggedInFromRepository();

        return postRepository.findAllByUserId(user.getId());
    }

    @Override
    public List<Post> viewAllPublicPostAndAllPostFriends() {

        User user = getUserLoggedInFromRepository();

        List<Post> publicPosts = postRepository.findAllByRangeOfPost(RangeOfPost.PUBLIC);

        Map<String, Post> usersPrivatePosts = postRepository.findAllByRangeOfPost(RangeOfPost.PRIVATE)
                .stream()
                .collect(Collectors.toMap(Post::getUserId, p -> p));

        List<Post> collect = user.getFriends()
                .stream()
                .filter(usersPrivatePosts::containsKey)
                .map(usersPrivatePosts::get)
                .collect(Collectors.toList());

        collect.addAll(publicPosts);
        return collect;

    }

    private User getUserLoggedInFromRepository() {

        return userRepository.findAll().stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(UserContextHolder.getUserLoggedIn()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Użytkownik " + UserContextHolder.getUserLoggedIn() + " nie istnieje"));
    }


}
