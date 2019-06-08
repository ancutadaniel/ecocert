package com.ecocert.core.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleanUpEventRepository extends JpaRepository <CleanUpEvent, Long> {
	public List<CleanUpEvent> getEventsBySocialId(Long socialId);
}
