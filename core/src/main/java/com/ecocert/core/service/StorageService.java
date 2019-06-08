package com.ecocert.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void createDirectory();
    public void store(MultipartFile file);

}