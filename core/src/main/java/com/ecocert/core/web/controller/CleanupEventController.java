package com.ecocert.core.web.controller;

import com.ecocert.core.domain.CleanupEvent;
import com.ecocert.core.domain.repository.CleanupEventRepository;
import com.ecocert.core.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("events")
public class CleanupEventController {
    @Autowired
    private CleanupEventRepository repo;

    @Autowired
    private StorageService storageService;

    @GetMapping
    public List<CleanupEvent> getEvents(@RequestParam(required = false, value = "socialId") Long socialId) {
//        if (socialId == null) {
            return repo.findAll();
//        }
//        return repo.findAll(socialId);
    }
}
