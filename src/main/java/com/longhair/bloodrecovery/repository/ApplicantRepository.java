package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByDirectDonation_Id(Long id);
    Optional<Applicant> findApplicantByApplicantIdentifyAndApplyStatus(String applicantIdentify, Boolean applyStatus);
}
