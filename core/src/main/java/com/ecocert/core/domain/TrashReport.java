package com.ecocert.core.domain;

import com.ecocert.core.authentication.model.User;
import com.ecocert.core.domain.enumeration.TrashSize;
import com.ecocert.core.domain.enumeration.TrashType;
import com.ecocert.core.web.config.Haversine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
public class TrashReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private int id;

	@Getter
	@Setter
	@OneToOne
	private ReportImage image;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Status status;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private TrashSize trashSize;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private TrashType trashType;

	@Getter
	@Setter
	private String comments;

	@Getter
	@Setter
	@ManyToOne
	private User user;

	@CreationTimestamp
	@Getter
	private LocalDateTime timestamp;

	/**
	 * Validates that the report image is within 10 km of the coordinates passed in as parameters
	 *
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public boolean isWithinRange(double latitude, double longitude) {
		double distance = Haversine.distance(image.getLatitude(), image.getLongitude(), latitude, longitude);
		return distance < 10;
	}

	public enum Status {
		NEW, CLEANED, SPAM
	}
}
