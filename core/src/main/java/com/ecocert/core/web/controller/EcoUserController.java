package com.ecocert.core.web.controller;

import com.ecocert.core.domain.EcoUser;
import com.ecocert.core.repository.EcoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecousers")
public class EcoUserController {
    @Autowired
    private EcoUserRepository repo;

    @GetMapping
    public List<EcoUser> getAllEcoUsers(){
        return repo.findAll();
    }

    @PostMapping
    public void createUser(@RequestBody EcoUser user){
        repo.save(user);
    }

}
