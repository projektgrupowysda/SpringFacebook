package com.sda.SpringFacebook.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserLoginRequest {
    private String login;
    private String password;
}
