package com.ecocert.core.web.controller;

import com.ecocert.core.domain.CleanupEvent;
import com.ecocert.core.domain.EventImage;
import com.ecocert.core.domain.ImageUploadResult;
import com.ecocert.core.domain.repository.CleanupEventRepository;
import com.ecocert.core.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("images")
public class EventImageController {
	@Autowired
	private StorageService storageService;

	@Autowired
	private CleanupEventRepository repo;

	@GetMapping
	public List<String> providePicturesById(@RequestParam Long eventId) {
		Optional<CleanupEvent> event = repo.findById(eventId);
		if (event.isPresent()) {
			List<EventImage> images = event.get().getImages();
			List<String> collectedList = images.stream().map(img -> img.getUuid()).collect(toList());
			System.out.println(collectedList.get(0));
			return collectedList;
		} else {
			return new ArrayList<>();
		}
	}

	@PostMapping
	public ImageUploadResult uploadImage(MultipartFile filepond) throws IOException {
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
