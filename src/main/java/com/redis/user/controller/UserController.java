package com.redis.user.controller;

import com.redis.user.domain.User;
import com.redis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping(value="/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id).get();
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @DeleteMapping(value= "/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }



}
