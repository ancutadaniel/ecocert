package com.ecocert.core.model;

import javax.persistence.*;

@Entity
public class EventImage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String uuid;

	public EventImage() {
	}

	public EventImage(String uuid) {
		this.uuid = uuid;
	}

	public int getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
