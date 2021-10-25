package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByDirectDonation_Id(Long id);
}
