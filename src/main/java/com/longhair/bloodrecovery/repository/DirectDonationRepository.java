package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.DirectDonation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface DirectDonationRepository extends JpaRepository<DirectDonation, Long> {
    List<DirectDonation> findDirectDonationsByPeriodToBefore(LocalDateTime date);
    List<DirectDonation> findDirectDonationsByBloodType(String bloodType);
    List<DirectDonation> findDirectDonationsByCompleteStatus(boolean completeStatus);
    List<DirectDonation> findDirectDonationsByLocationSidoAndLocationSigungu(String sido, String sigungu);
    List<DirectDonation> findDirectDonationsByBloodTypeAndCompleteStatus(String bloodType, boolean completeStatus);
    List<DirectDonation> findDirectDonationsByBloodTypeAndLocationSidoAndLocationSigungu(String bloodType, String sido, String sigungu);
    List<DirectDonation> findDirectDonationsByCompleteStatusAndLocationSidoAndLocationSigungu(boolean completeStatus, String sido, String sigungu);
    List<DirectDonation> findDirectDonationsByBloodTypeAndCompleteStatusAndLocationSidoAndLocationSigungu(String bloodType, boolean completeStatus, String sido, String sigungu);

}
