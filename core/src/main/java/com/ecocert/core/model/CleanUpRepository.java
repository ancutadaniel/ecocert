package com.ecocert.core.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanUpRepository  extends JpaRepository <CleanUpEvent, Long> {
}
