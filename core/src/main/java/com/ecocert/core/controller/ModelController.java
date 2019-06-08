package com.ecocert.core.controller;

import com.ecocert.core.model.User;
import com.ecocert.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public void createUser(@RequestBody User user){
        repository.save(user);
    }

}
