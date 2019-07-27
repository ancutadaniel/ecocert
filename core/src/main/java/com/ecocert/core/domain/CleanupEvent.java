package com.ecocert.core.domain;


import com.ecocert.core.domain.enumeration.TrashQuantity;
import com.ecocert.core.domain.enumeration.TrashType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CleanupEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long socialId;
	@Enumerated(EnumType.STRING)
	private TrashQuantity trashQuantity;
	@Enumerated(EnumType.STRING)
	private TrashType trashType;
	private String info;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private EcoUser user;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ReportImage> images;
}
