package com.ecocert.core.web.services;

import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.domain.repository.TrashReportRepository;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("TrashReportService")
public class TrashReportServiceImpl implements TrashReportService {
    @Autowired
    TrashReportRepository repo;

    @Override
    public void saveTrashReport(TrashReportDto trashReportDto) {
        TrashReport trashReport = convertToDTO(trashReportDto);
        repo.save(trashReport);
    }

    @Override
    public List<TrashReportDto> getAllTrashReports() {
        return repo.findAll().stream().map(this::convertToEntity).collect(Collectors.toList());
    }


    private TrashReport convertToDTO(TrashReportDto trashReportDto) {
        TrashReport trashReport = new TrashReport();
        trashReport.setImageUploadResult(trashReportDto.getImageUploadResult());
        trashReport.setTimestamp(trashReportDto.getTimestamp());
        trashReport.setStatus(trashReportDto.getStatus());
        trashReport.setUser(trashReportDto.getUser());
        trashReport.setTrashQuantity(trashReportDto.getTrashQuantity());
        trashReport.setTrashType(trashReportDto.getTrashType());
        trashReport.setComments(trashReportDto.getComments());
        return trashReport;
    }

    private TrashReportDto convertToEntity(TrashReport trashReportD) {
        TrashReportDto trashReportDto = new TrashReportDto();
        trashReportDto.setImageUploadResult(trashReportD.getImageUploadResult());
        trashReportDto.setTimestamp(trashReportD.getTimestamp());
        trashReportDto.setStatus(trashReportD.getStatus());
        trashReportDto.setUser(trashReportD.getUser());
        trashReportDto.setTrashQuantity(trashReportD.getTrashQuantity());
        trashReportDto.setTrashType(trashReportD.getTrashType());
        trashReportDto.setComments(trashReportD.getComments());
        return trashReportDto;
    }
}
