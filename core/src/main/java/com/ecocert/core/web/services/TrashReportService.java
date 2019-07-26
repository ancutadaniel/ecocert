package com.ecocert.core.web.services;

import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.web.dto.TrashReportDto;

import java.util.List;

public interface TrashReportService {
    void saveTrashReport(TrashReportDto trashReportDto);
    List<TrashReportDto> getAllTrashReports();
}
