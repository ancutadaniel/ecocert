package com.ecocert.core.domain.services;

import com.ecocert.core.authentication.model.User;
import com.ecocert.core.domain.ReportImage;
import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.domain.repository.ReportImageRepository;
import com.ecocert.core.domain.repository.TrashReportRepository;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
public class TrashReportService {
	@Autowired
	TrashReportRepository repo;
	@Autowired
	ReportImageRepository imageRepo;

	public void saveTrashReport(User user, TrashReportDto trashReportDto) {
		TrashReport trashReport = new TrashReport();
		fromDto(trashReport, trashReportDto);
		trashReport.setUser(user);
		repo.save(trashReport);
	}

	public List<TrashReport> getAllTrashReports(User user) {
		return repo.findAllByUser(user);
	}

	public List<TrashReportDto> getTrashReportsInCoordinateRange(User user, double latitude, double longitude) {
		List<TrashReport> allByUser = repo.findAllByUser(user);
		allByUser.stream()
				.filter(r -> r.isWithinRange(latitude, longitude))
				.collect(toList());
		return allByUser.stream().map(TrashReportDto::new).collect(toList());
	}


	private void fromDto(TrashReport report, TrashReportDto trashReportDto) {
		ReportImage reportImage = validateTrashReport(trashReportDto);
		report.setComments(trashReportDto.getInfo());
		report.setStatus(TrashReport.Status.NEW);
		report.setTrashSize(trashReportDto.getTrashSize());
		report.setTrashType(trashReportDto.getTrashType());
		report.setImage(reportImage);
	}

	private ReportImage validateTrashReport(TrashReportDto report) {
		if (report.getImage() == null || report.getImage().isEmpty()) {
			throw new IllegalArgumentException("error.report.imageMandatory");
		}

		if (report.getTrashSize() == null) {
			throw new IllegalArgumentException("error.report.sizeMandatory");
		}

		if (report.getTrashType() == null) {
			throw new IllegalArgumentException("error.report.typeMandatory");
		}

		ReportImage image = imageRepo.getOne(report.getImage()); // TODO: this might throw exception if there are multiple records with the same uuid
		if (image == null) {
			throw new IllegalArgumentException("error.report.imageInvalid");
		}

		TrashReport existingReport = repo.findByImage_Uuid(image.getUuid());
		if (existingReport != null) {
			throw new IllegalArgumentException("error.report.imageAlreadyUploaded");
		}
		return image;
	}
}
