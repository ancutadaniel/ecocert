package com.ecocert.core.domain;

import com.ecocert.core.authentication.model.User;
import com.ecocert.core.domain.enumeration.TrashSize;
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

	public enum Status {
		NEW, CLEANED, SPAM
	}
}
