package com.sda.SpringFacebook.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateUserRequest {



    private String firstName;
    private String lastName;
    private String password;

}
