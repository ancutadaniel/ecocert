package com.ecocert.core.web.controller;

import com.ecocert.core.domain.CleanupEvent;
import com.ecocert.core.repository.CleanupEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class CleanupEventController {
	@Autowired
	private CleanupEventRepository repo;

	@GetMapping
	public List<CleanupEvent> getEvents(@RequestParam(required = false, value = "socialId") Long socialId) {
		if (socialId == null) {
			return repo.findAll();
		}
		return repo.getEventsBySocialId(socialId);
	}

	@PostMapping
	public void addEvent(@RequestBody CleanupEvent cleanUpEvent) {
		repo.save(cleanUpEvent);
	}
}
