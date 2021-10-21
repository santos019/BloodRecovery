package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.DirectDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectDonationRepository extends JpaRepository<DirectDonation, Long> {
}
