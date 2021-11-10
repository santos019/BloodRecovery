package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.entity.DonationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationHistoryRepository extends JpaRepository<DonationHistory, Long> {

}


