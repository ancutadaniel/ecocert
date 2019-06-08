package com.ecocert.core.controller;

import com.ecocert.core.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @Autowired
    private StorageService storageService;

@PostMapping("images")
    public void getPicture(MultipartFile image){
    storageService.store(image);
    }
}
