package com.ecocert.core.web.dto;

import com.ecocert.core.domain.ReportImage;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageUploadDto {
	private double longitude;
	private double latitude;
	private String imageUUID;

	public ImageUploadDto(String uuid) {
		this.imageUUID = uuid;
	}

	public ImageUploadDto(ReportImage image) {
		this.longitude = image.getLongitude();
		this.latitude = image.getLatitude();
		this.imageUUID = image.getUuid();
	}
}
