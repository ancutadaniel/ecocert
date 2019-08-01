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

	//	@PostMapping("/report")
//	public void report(@AuthenticationPrincipal UserPrincipal userPrincipal, TrashReportDto report) {
//		if (userPrincipal == null || report.anonymous()) {
//			// TODO: raport anonim
//			TrashReport t = new TrashReport();
//
//			t.setUser(null);
//		} else {
//			// TODO: raport cu user
//			t.setUser(getUserFromPrincipal(userPrincipal));
//		}
//	}
	@GetMapping
	public List<TrashReportDto> getReports() {
		return service.getAllTrashReports();
	}

	//TODO de adaugat user.
	@PostMapping
	public void report(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody TrashReportDto report) {
		if (userPrincipal == null) {
			throw new IllegalArgumentException("Reports cannot be anonymous yet!");
		}
		User user = userRepo.getOne(userPrincipal.getId());//findByEmail(userPrincipal.getEmail()).orElseThrow(() -> new IllegalStateException("You have to be logged in to make a report!"));

		service.saveTrashReport(user, report);
	}
}
