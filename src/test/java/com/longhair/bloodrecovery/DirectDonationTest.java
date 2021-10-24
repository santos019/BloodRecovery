package com.longhair.bloodrecovery;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class DirectDonationTest {
    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    DirectDonationRepository directDonationRepository;

    @Test
    public void testInsertDummy(){
        DirectDonation directDonation = new DirectDonation();
        directDonation.setRequesterId(123L);
        directDonation.setRequesterNickname("EhitEpit");
        directDonation.setRequesterLevel(5);
        directDonation.setTitle("제목");
        directDonation.setContents("내용");
        directDonation.setImage("이미지");
        directDonation.setDate(new Date());
        directDonation.setLocationSido(1);
        directDonation.setLocationSigungu(2);
        directDonation.setPeriodFrom(new Date());
        directDonation.setPeriodTo(new Date(10000));
        directDonation.setBloodType("A");
        directDonation.setBloodMaxCount(5);
        directDonation.setBloodCurrentCount(1);
        directDonation.setCompleteStatus(false);
        directDonation.setPatientName("나청일");
        directDonation.setHospitalName("백병원");
        directDonation.setRoomNumber("205");

        Applicant applicant = new Applicant();
        applicant.setApplicantNickname("pray");
        applicant.setApplyStatus(false);

        directDonationRepository.save(directDonation);
        applicantRepository.save(applicant);
//
//        System.out.println("============ directDonations ============");
//        System.out.println(directDonationRepository.findById(1L));
//        System.out.println("============ applicants ============");
//        System.out.println(applicantRepository.findById(1L));
    }
}
