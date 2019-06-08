package com.ecocert.core.repository;

import com.ecocert.core.domain.EcoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoUserRepository extends JpaRepository<EcoUser, Long> {
}
