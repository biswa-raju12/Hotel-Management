package com.dailycodehunt.UserService.services;

import com.dailycodehunt.UserService.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all users

    List<User> getAllUsers();

    //get single user of given userId

    User getUser(String userId);

    String deleteUser(String userId);

    User updateUser(String userId,User user);

}
