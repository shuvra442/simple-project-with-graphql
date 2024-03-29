package com.springBootGraphql.controller;

import com.springBootGraphql.model.User;
import com.springBootGraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    Create User
    @MutationMapping
    public User createUser(@Argument String userName, @Argument String userEmail, @Argument String userPh){
        User user= new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPh(userPh);
        return userService.createUser(user);
    }

//    Get all Users
    @QueryMapping(name = "getUsers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

//    get single user
    @QueryMapping
    public User getUser(@Argument int id){
        return userService.getUser(id);
    }

//    let's try to update user in letter
//    Update User
    @MutationMapping
    public User updateUser(@Argument int id,@Argument String
            userName, @Argument String userEmail, @Argument String userPh){

        User user= new User();
       user.setId(id);
       user.setUserName(userName);
       user.setUserEmail(userEmail);
       user.setUserPh(userPh);
        return userService.updateUser(user);
    }

//    Delete user
    @MutationMapping
    public Boolean deleteUser(@Argument int id){
        return  userService.deleteUser(id);
    }
}
