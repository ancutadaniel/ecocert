package com.ecocert.core.web.controller;

import com.ecocert.core.domain.CleanupEvent;
import com.ecocert.core.domain.EventImage;
import com.ecocert.core.domain.repository.CleanupEventRepository;
import com.ecocert.core.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class CleanupEventController {
	@Autowired
	private CleanupEventRepository repo;

	@Autowired
	private StorageService storageService;

	@GetMapping
	public List<CleanupEvent> getEvents(@RequestParam(required = false, value = "socialId") Long socialId) {
		if (socialId == null) {
			return repo.findAll();
		}
		return repo.getEventsBySocialId(socialId);
	}

	@PostMapping
	public void addEvent(@RequestBody CleanupEvent cleanUpEvent) {
		try {
			cleanUpEvent.getImages().stream().forEach(this::fillCoordinates);
		} catch(Exception e){ // numai la hackathon
		}

		repo.save(cleanUpEvent);
	}

	private void fillCoordinates(EventImage e) {
		double[] gps = storageService.getCoordinatesForStoredImage(e.getUuid());
		e.setLongitude(gps[0]);
		e.setLatitude(gps[1]);
	}
}
