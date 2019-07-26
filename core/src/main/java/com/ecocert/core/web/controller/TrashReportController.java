package com.ecocert.core.web.controller;

import com.ecocert.core.web.dto.TrashReportDto;
import com.ecocert.core.web.services.TrashReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// TODO: verificat ID daca e correct in caz contrar de folosit email, adaugat email in EcoUser!
//  de adaugat logica in functie de User.

@RestController
@RequestMapping("trashReport")
public class TrashReportController {
    @Autowired
    private TrashReportService repo;

    //TODO de adaugat user.
    @PostMapping("/report")
    public void report(TrashReportDto report) {
        repo.saveTrashReport(report);
    }

    @GetMapping("/getReports")
    public List<TrashReportDto> getReports() {
        return repo.getAllTrashReports();
    }

}
