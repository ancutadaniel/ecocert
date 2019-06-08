package com.ecocert.core.repository;

import com.ecocert.core.domain.CleanupEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleanupEventRepository extends JpaRepository <CleanupEvent, Long> {
	public List<CleanupEvent> getEventsBySocialId(Long socialId);

}
