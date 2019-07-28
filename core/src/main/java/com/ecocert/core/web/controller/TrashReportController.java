package com.ecocert.core.web.controller;

import com.ecocert.core.authentication.security.UserPrincipal;
import com.ecocert.core.domain.services.TrashReportService;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reports")
public class TrashReportController {
	@Autowired
	private TrashReportService service;

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
	public void report(@AuthenticationPrincipal UserPrincipal userPrincipal, TrashReportDto report) {
		if (userPrincipal == null) {
			throw new IllegalArgumentException("Reports cannot be anonymous yet!");
		}
//		service.saveTrashReport(userPrincipal.getreport);
	}
}
