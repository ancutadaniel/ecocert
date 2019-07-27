package com.ecocert.core.domain;

import com.ecocert.core.domain.enumeration.ReportStatus;
import com.ecocert.core.domain.enumeration.TrashQuantity;
import com.ecocert.core.domain.enumeration.TrashType;
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

//	@Getter
//	@Setter
//	private ReportImage image;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private ReportStatus status;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private TrashQuantity trashQuantity;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private TrashType trashType;

	@Getter
	@Setter
	private String comments;

//	@Getter
//	@Setter
//	private User user;

	@CreationTimestamp
	@Getter
	private LocalDateTime timestamp;
}
