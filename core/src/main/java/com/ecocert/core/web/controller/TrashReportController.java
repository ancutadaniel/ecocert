package com.ecocert.core.web.controller;

import com.ecocert.core.authentication.model.User;
import com.ecocert.core.authentication.repository.UserRepository;
import com.ecocert.core.authentication.security.UserPrincipal;
import com.ecocert.core.domain.services.TrashReportService;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reports")
public class TrashReportController {
	@Autowired
	private TrashReportService service;

	@Autowired
	private UserRepository userRepo;

	@GetMapping
	public List<TrashReportDto> getReports(@AuthenticationPrincipal UserPrincipal userPrincipal) {
		return service.getAllTrashReports(userRepo.getOne(userPrincipal.getId()));
	}

	@PostMapping
	public void report(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody TrashReportDto report) {
		if (userPrincipal == null) {
			throw new IllegalArgumentException("Reports cannot be anonymous yet!");
		}
		User user = userRepo.getOne(userPrincipal.getId());

		service.saveTrashReport(user, report);
	}
}
