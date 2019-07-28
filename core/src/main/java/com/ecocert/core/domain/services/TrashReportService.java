package com.ecocert.core.domain.services;

import com.ecocert.core.authentication.model.User;
import com.ecocert.core.domain.ReportImage;
import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.domain.enumeration.ReportStatus;
import com.ecocert.core.domain.repository.ReportImageRepository;
import com.ecocert.core.domain.repository.TrashReportRepository;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrashReportService {
	@Autowired
	TrashReportRepository repo;
	@Autowired
	ReportImageRepository imageRepo;

	public void saveTrashReport(User user, TrashReportDto trashReportDto) {
		TrashReport trashReport = new TrashReport();
		fromDto(trashReport, trashReportDto);
		repo.save(trashReport);
	}

	public List<TrashReportDto> getAllTrashReports() {
		return repo.findAll().stream().map(this::convertToEntity).collect(Collectors.toList());
	}

	private void fromDto(TrashReport report, TrashReportDto trashReportDto) {
		ReportImage reportImage = validateTrashReport(trashReportDto);
		report.setComments(trashReportDto.getInfo());
		report.setStatus(ReportStatus.NEW);
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

		ReportImage image = imageRepo.findByUuid(report.getImage()); // TODO: this might throw exception if there are multiple records with the same uuid
		if (image == null) {
			throw new IllegalArgumentException("error.report.imageInvalid");
		}

		TrashReport existingReport = repo.findByImage_Uuid(image.getUuid());
		if (existingReport != null) {
			throw new IllegalArgumentException("error.report.imageAlreadyUploaded");
		}
		return image;
	}

	private TrashReportDto convertToEntity(TrashReport trashReportD) {
		TrashReportDto trashReportDto = new TrashReportDto();
//        trashReportDto.setImageUploadDto(trashReportD.getImageUploadResult());
//        trashReportDto.setTimestamp(trashReportD.getTimestamp());
//        trashReportDto.setStatus(trashReportD.getStatus());
//        trashReportDto.setUser(trashReportD.getUser());
//        trashReportDto.setTrashSize(trashReportD.getTrashSize());
//        trashReportDto.setTrashType(trashReportD.getTrashType());
//        trashReportDto.setComments(trashReportD.getComments());
		return trashReportDto;
	}
}
