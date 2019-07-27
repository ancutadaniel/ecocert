package com.ecocert.core.web.controller;

import com.ecocert.core.web.dto.ImageUploadDto;
import com.ecocert.core.domain.ReportImage;
import com.ecocert.core.domain.repository.ReportImageRepository;
import com.ecocert.core.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("images")
public class ReportImageController {
	@Autowired
	private StorageService storageService;

	@Autowired
	private ReportImageRepository repo;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");

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
		ReportImage image = parseExifData(filepond.getInputStream());

		String uuid = storageService.store(filepond);
		image.setUuid(uuid);
		repo.save(image);

		return new ImageUploadDto(image.getLongitude(), image.getLatitude(), uuid);
	}

	public ReportImage parseExifData(InputStream is) {
		javaxt.io.Image img = new javaxt.io.Image(is);
		HashMap<Integer, Object> exifTags = img.getExifTags();

		if (exifTags == null) {
			throw new IllegalArgumentException("Cannot upload image without EXIF data!");
		}

		ReportImage image = new ReportImage();
		double[] gps = img.getGPSCoordinate();
		image.setLongitude(gps[0]);
		image.setLatitude(gps[1]);
		image.setTakenOn(LocalDateTime.parse(String.valueOf(exifTags.get(0x0132)), dtf));
		return image;
	}
}
