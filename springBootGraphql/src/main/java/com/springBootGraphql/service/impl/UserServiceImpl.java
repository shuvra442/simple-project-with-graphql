package com.springBootGraphql.service.impl;

import com.springBootGraphql.helper.Excpetions;
import com.springBootGraphql.model.User;
import com.springBootGraphql.repository.UserRepo;
import com.springBootGraphql.service.UserService;
import org.hibernate.internal.util.ExceptionHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.Exceptions;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existingUser=userRepo.findById(user.getId()).get();
        existingUser.setUserName(user.getUserName());
        existingUser.setUserCity(user.getUserCity());
        existingUser.setUserPh(user.getUserPh());
        existingUser.setUserEmail(user.getUserEmail());
        return userRepo.save(existingUser);
    }

    @Override
    public  User getUser(int userId) {
        return userRepo.findById(userId).orElseThrow(Excpetions::throwResourceNotFounfException);
    }
    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public Boolean deleteUser(int userId) {
        User user= userRepo.findById(userId).orElseThrow(Excpetions::throwResourceNotFounfException);
        userRepo.delete(user);
        return true;
    }
}
