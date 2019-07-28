package com.ecocert.core.domain.services;

import com.ecocert.core.domain.ReportImage;
import com.ecocert.core.domain.repository.ReportImageRepository;
import com.ecocert.core.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ReportImageService {
	@Autowired
	private StorageService storageService;

	@Autowired
	private ReportImageRepository repo;

	public ReportImage saveImage(MultipartFile multipartFile) throws IOException {
		ReportImage image = ReportImage.fromExifData(multipartFile.getInputStream());

		String uuid = storageService.store(multipartFile);
		image.setUuid(uuid);
		return repo.save(image);
	}
}
