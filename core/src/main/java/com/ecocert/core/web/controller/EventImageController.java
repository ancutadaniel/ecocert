package com.ecocert.core.web.controller;

import com.ecocert.core.domain.ImageUploadResult;
import com.ecocert.core.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("images")
public class EventImageController {
	@Autowired
	private StorageService storageService;

	@PostMapping
	public ImageUploadResult getPicture(MultipartFile filepond) throws IOException {
		javaxt.io.Image img = new javaxt.io.Image(filepond.getInputStream());
		double[] gps = img.getGPSCoordinate();

		String uuid = storageService.store(filepond);
		if (gps != null) {
			return new ImageUploadResult(gps[0], gps[1], uuid);
		} else {
			return new ImageUploadResult(uuid);
		}
	}
}
