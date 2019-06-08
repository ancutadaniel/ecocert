package com.ecocert.core.storage;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class StorageService {
	private final Path rootLocation;

	@Autowired
	public StorageService(StorageDirectory storageDirectory) {
		this.rootLocation = Paths.get(storageDirectory.getLocation());
	}

	public void createDirectory() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("Could not initialize storage", e);
		}
	}

	public String store(MultipartFile file) throws IOException {
		String fileName = null;
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
			}
			if (file.getOriginalFilename().contains("..")) {
				// This is a security check
				throw new StorageException(
						"Cannot store file with relative path outside current directory "
								+ file.getOriginalFilename());
			}
			String md5Hex = DigestUtils.md5DigestAsHex(file.getBytes()).toUpperCase();
			fileName = md5Hex + "." + FilenameUtils.getExtension(file.getOriginalFilename());

			if (imageFileExists(fileName)) return fileName;


			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(fileName),
						StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
		}
		return fileName;
	}

	private boolean imageFileExists(String fileName) throws IOException {
		boolean fileExists = Files.list(this.rootLocation).anyMatch(e -> e.endsWith(fileName));
		return fileExists;
	}

	public void getCoordinates(MultipartFile image) throws IOException {
		javaxt.io.Image img = new javaxt.io.Image(image.getInputStream());
		double[] gps = img.getGPSCoordinate();
		log.debug("Coordinates for " + image.getOriginalFilename() + " are: " + gps[0] + ", " + gps[1]);
	}

	public double[] getCoordinatesForStoredImage(String imageUUID) {
		javaxt.io.Image img = new javaxt.io.Image(this.rootLocation.resolve(imageUUID).toFile());
		double[] gps = img.getGPSCoordinate();
		return gps;
	}
}
