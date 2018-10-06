package com.sda.SpringFacebook.services;

import com.sda.SpringFacebook.request.UpdateUserRequest;

public interface UserEditService {

    void changeUserDataById (UpdateUserRequest request, String userId);

}
