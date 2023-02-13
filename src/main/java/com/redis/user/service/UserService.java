package com.redis.user.service;

import com.redis.user.domain.User;
import com.redis.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUser(String id){
        return userRepository.findById(id);
    }

    public List<User> getAllUser(){
        Iterable<User> userIterator = userRepository.findAll();
        return StreamSupport.stream(userIterator.spliterator(),true).collect(Collectors.toList());
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
