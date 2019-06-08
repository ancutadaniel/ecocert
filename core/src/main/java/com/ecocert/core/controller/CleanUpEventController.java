package com.ecocert.core.controller;

import com.ecocert.core.model.CleanUpEvent;
import com.ecocert.core.model.CleanUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class CleanUpEventController {
    @Autowired
    private CleanUpRepository repository;

    @GetMapping
    public List<CleanUpEvent> getAllEvents() {
        return repository.findAll();
    }

    @PostMapping
    public void addEvent(@RequestBody CleanUpEvent cleanUpEvent) {
        repository.save(cleanUpEvent);

    }
}
