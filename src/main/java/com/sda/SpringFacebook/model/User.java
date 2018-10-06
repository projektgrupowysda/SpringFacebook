package com.sda.SpringFacebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String login;
    private String firstName;
    private String lastName;
    private String password;

    private List<User> friends;


}
