package com.sda.SpringFacebook.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {

    private String login;
    private String firstName;
    private String lastName;
    private String password;

    private List<String> friends;

}