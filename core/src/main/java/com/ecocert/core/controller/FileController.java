package com.ecocert.core.controller;

import com.ecocert.core.model.ImageUploadResult;
import com.ecocert.core.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    private StorageService storageService;

    @PostMapping("images")
    public ImageUploadResult getPicture(MultipartFile filepond) throws IOException {

        javaxt.io.Image img = new javaxt.io.Image(filepond.getInputStream());
        double[] gps = img.getGPSCoordinate();

        String uuid = storageService.store(filepond);
        if (gps != null) {
            return new ImageUploadResult(gps[0], gps[1],uuid);
        } else {
            return new ImageUploadResult(uuid);
        }
    }
}
