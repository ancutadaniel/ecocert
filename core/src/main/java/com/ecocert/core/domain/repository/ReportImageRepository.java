package com.ecocert.core.domain.repository;

import com.ecocert.core.domain.ReportImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportImageRepository extends JpaRepository<ReportImage, String> {
}
