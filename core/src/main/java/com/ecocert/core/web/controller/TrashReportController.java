package com.ecocert.core.web.controller;

import com.ecocert.core.authentication.exception.ResourceNotFoundException;
import com.ecocert.core.authentication.model.User;
import com.ecocert.core.authentication.security.UserPrincipal;
import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrashReportController {

	@PostMapping("/report")
	public void report(@AuthenticationPrincipal UserPrincipal userPrincipal, TrashReportDto report) {
//		if (userPrincipal == null || report.anonymous()) {
//			// TODO: raport anonim
//			TrashReport t = new TrashReport();
//
//			t.setUser(null);
//		} else {
//			// TODO: raport cu user
//			t.setUser(getUserFromPrincipal(userPrincipal));
//		}
	}
}
