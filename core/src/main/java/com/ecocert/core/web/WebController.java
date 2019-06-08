package com.ecocert.core.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@GetMapping //TODO: remove
	public int getCoordinatesFromImage() {
		return -1;
	}

	@DeleteMapping //TODO: remove
	public void deleteTrashIncident() {
	}
}
