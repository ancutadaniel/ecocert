package com.ecocert.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class EventImage {
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
}
