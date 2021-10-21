package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
