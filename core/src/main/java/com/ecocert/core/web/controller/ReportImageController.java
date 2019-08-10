package com.ecocert.core.web.controller;

import com.ecocert.core.domain.ReportImage;
import com.ecocert.core.domain.services.ReportImageService;
import com.ecocert.core.web.dto.ImageUploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("images")
public class ReportImageController {
	@Autowired
	private ReportImageService service;

	@PostMapping
	public ImageUploadDto uploadImage(@RequestParam("filepond") MultipartFile filepond) throws IOException {
		ReportImage image = service.saveImage(filepond);

		return new ImageUploadDto(image);
	}
}
