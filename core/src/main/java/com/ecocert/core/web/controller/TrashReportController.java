package com.ecocert.core.web.controller;

import com.ecocert.core.domain.services.TrashReportService;
import com.ecocert.core.web.dto.TrashReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// TODO: verificat ID daca e correct in caz contrar de folosit email, adaugat email in EcoUser!
//  de adaugat logica in functie de User.

@RestController
@RequestMapping("reports")
public class TrashReportController {
    @Autowired
    private TrashReportService service;

    @GetMapping
    public List<TrashReportDto> getReports() {
        return service.getAllTrashReports();
    }

    //TODO de adaugat user.
    @PostMapping
    public void report(TrashReportDto report) {
        service.saveTrashReport(report);
    }
}
