package com.sda.SpringFacebook.database;

import com.sda.SpringFacebook.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
