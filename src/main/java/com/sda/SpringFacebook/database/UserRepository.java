package com.sda.SpringFacebook.database;

import com.sda.SpringFacebook.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

    User findById (String id);



}
