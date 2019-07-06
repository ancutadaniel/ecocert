package com.ecocert.core.web.controller;

import com.ecocert.core.authentication.exception.ResourceNotFoundException;
import com.ecocert.core.authentication.model.User;
import com.ecocert.core.authentication.security.UserPrincipal;
import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.domain.repository.TrashReportRepository;
import com.ecocert.core.web.dto.TrashReportDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrashReportController {
	@Autowired
	private TrashReportRepository repo;

	@PostMapping("/report")
	public void report(@AuthenticationPrincipal UserPrincipal userPrincipal, TrashReportDto report) {
		ModelMapper modelMapper = new ModelMapper();
		TrashReport t = new TrashReport();
		if (userPrincipal == null || report.isAnonymous()) {
			// TODO: raport anonim


			t.setUser(null);
			modelMapper.map(report,t);

		} else {

			// TODO: raport cu user
			t.setUser(getUserFromPrincipal(userPrincipal));
		}

		repo.save(t);
	}
}
