package com.ecocert.core.domain.repository;

import com.ecocert.core.domain.TrashReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashReportRepository extends JpaRepository<TrashReport, Long> {
	TrashReport findByImage_Uuid(String uuid);
}
