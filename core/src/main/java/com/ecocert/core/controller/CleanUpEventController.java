package com.ecocert.core.controller;

import com.ecocert.core.model.CleanUpEvent;
import com.ecocert.core.model.CleanUpEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class CleanUpEventController {
	@Autowired
	private CleanUpEventRepository repository;

	@GetMapping
	public List<CleanUpEvent> getEvents(@RequestParam(required = false, value = "socialId") Long socialId) {
		if (socialId == null) {
			return repository.findAll();
		}
		return repository.getEventsBySocialId(socialId);
	}

	@PostMapping
	public void addEvent(@RequestBody CleanUpEvent cleanUpEvent) {
		repository.save(cleanUpEvent);
	}
}
