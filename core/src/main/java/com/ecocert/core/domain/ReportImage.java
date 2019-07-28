package com.ecocert.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@NoArgsConstructor
@Entity
public class ReportImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private int id;

	@Getter
	@Setter
	private String uuid;

	@Getter
	@Setter
	private double longitude;

	@Getter
	@Setter
	private double latitude;

	@Getter
	@Setter
	private LocalDateTime takenOn;

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");

	public static ReportImage fromExifData(InputStream is) {
		javaxt.io.Image img = new javaxt.io.Image(is);
		HashMap<Integer, Object> exifTags = img.getExifTags();

		if (exifTags == null) {
			throw new IllegalArgumentException("Image does not have EXIF data!");
		}

		ReportImage image = new ReportImage();
		double[] gps = img.getGPSCoordinate();
		image.setLongitude(gps[0]);
		image.setLatitude(gps[1]);
		image.setTakenOn(LocalDateTime.parse(String.valueOf(exifTags.get(0x0132)), dtf));
		return image;
	}
}
