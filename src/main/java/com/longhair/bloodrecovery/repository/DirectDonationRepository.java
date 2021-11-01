package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.DirectDonation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DirectDonationRepository extends JpaRepository<DirectDonation, Long> {
    List<DirectDonation> findDirectDonationsByPeriodToBefore(Date date);
    List<DirectDonation> findDirectDonationsByBloodType(String bloodType);
    List<DirectDonation> findDirectDonationsByCompleteStatus(boolean completeStatus);
    List<DirectDonation> findDirectDonationsByLocationSidoAndLocationSigungu(int sido, int sigungu);
    List<DirectDonation> findDirectDonationsByBloodTypeAndCompleteStatus(String bloodType, boolean completeStatus);
    List<DirectDonation> findDirectDonationsByBloodTypeAndLocationSidoAndLocationSigungu(String bloodType, int sido, int sigungu);
    List<DirectDonation> findDirectDonationsByCompleteStatusAndLocationSidoAndLocationSigungu(boolean completeStatus, int sido, int sigungu);
    List<DirectDonation> findDirectDonationsByBloodTypeAndCompleteStatusAndLocationSidoAndLocationSigungu(String bloodType, boolean completeStatus, int sido, int sigungu);

}
