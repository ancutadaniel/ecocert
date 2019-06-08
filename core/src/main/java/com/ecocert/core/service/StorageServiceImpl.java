package com.ecocert.core.service;

import com.ecocert.core.model.StorageDirectory;
import com.ecocert.core.model.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;
//TODO create check for image  type accepted

    @Autowired
    public StorageServiceImpl(StorageDirectory storageDirectory) {
        this.rootLocation = Paths.get(storageDirectory.getLocation());
    }

    @Override
    public void createDirectory() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + fileName);
            }
            if (fileName.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + fileName);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + fileName, e);
        }
    }

    public void getCoordinates(MultipartFile image) throws IOException {
        javaxt.io.Image img = new javaxt.io.Image(image.getInputStream());
        double[] gps = img.getGPSCoordinate();
        System.out.println(gps);
    }
}
