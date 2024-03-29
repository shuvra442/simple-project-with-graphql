package com.springBootGraphql.service;

import com.springBootGraphql.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public User createUser(User user);

    public User updateUser(User user);

    public User getUser(int userId);
    public List<User> getAllUser();

    public Boolean deleteUser(int userId);


}
