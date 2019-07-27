package com.ecocert.core.domain;


import com.ecocert.core.domain.enumeration.TrashSize;
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
	private TrashSize trashSize;
	@Enumerated(EnumType.STRING)
	private TrashType trashType;
	private String info;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ReportImage> images;
}
