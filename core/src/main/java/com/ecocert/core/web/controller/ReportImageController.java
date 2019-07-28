package com.ecocert.core.web.controller;

import com.ecocert.core.domain.ReportImage;
import com.ecocert.core.domain.services.ReportImageService;
import com.ecocert.core.web.dto.ImageUploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("images")
public class ReportImageController {
	@Autowired
	private ReportImageService service;

	@GetMapping
	public List<String> providePicturesById(@RequestParam Long eventId) {
//		Optional<CleanupEvent> event = repo.findById(eventId);
//		if (event.isPresent()) {
//			List<ReportImage> images = event.get().getImages();
//			List<String> collectedList = images.stream().map(img -> img.getUuid()).collect(toList());
//			System.out.println(collectedList.get(0));
//			return collectedList;
//		} else {
			return new ArrayList<>();
//		}
	}

	@PostMapping
	public ImageUploadDto uploadImage(MultipartFile filepond) throws IOException {
		ReportImage image = service.saveImage(filepond);

		return new ImageUploadDto(image);
	}
}
