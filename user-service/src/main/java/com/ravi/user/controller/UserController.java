package com.ravi.user.controller;

import com.ravi.user.VO.ResponseTemplateVO;
import com.ravi.user.entity.User;
import com.ravi.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("Inside Controller - Post User details");
        return userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public ResponseTemplateVO getUserDetailsWithDeptId(@PathVariable("id") Long userId)
    {
        return userService.getUserDetailsWithDeptId(userId);
    }
}
