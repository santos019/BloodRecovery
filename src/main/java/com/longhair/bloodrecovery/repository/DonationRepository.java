package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findDonationByCardRequestId(Long requestId);
    List<Donation> deleteByCardRequestId(Long requestId);
}
