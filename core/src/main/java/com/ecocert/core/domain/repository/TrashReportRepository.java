package com.ecocert.core.domain.repository;

import com.ecocert.core.authentication.model.User;
import com.ecocert.core.domain.TrashReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrashReportRepository extends JpaRepository<TrashReport, Long> {
	TrashReport findByImage_Uuid(String uuid);

	List<TrashReport> findAllByUser(User u);
}
