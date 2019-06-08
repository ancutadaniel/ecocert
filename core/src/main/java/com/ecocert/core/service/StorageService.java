package com.ecocert.core.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    void createDirectory();
    public String store(MultipartFile file) throws IOException;

}