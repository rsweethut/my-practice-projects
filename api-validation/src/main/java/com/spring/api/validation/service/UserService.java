package com.spring.api.validation.service;

import com.spring.api.validation.dto.UserRequest;
import com.spring.api.validation.entity.User;
import com.spring.api.validation.exception.UserNotFoundException;
import com.spring.api.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),
                userRequest.getNationality());
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepo.findByUserId(id);
        if(user!=null)
            return user;
        else
            throw new UserNotFoundException("Invalid ID or Data not Found for the id "+id);
    }
}
