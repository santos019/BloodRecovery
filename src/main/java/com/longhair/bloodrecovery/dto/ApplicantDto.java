package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

@Data
public class ApplicantDto {
    private Long id;
    private String applicantIdentify;
    private String applicantNickname;
    private Boolean applyStatus;
    private Long directDonationId;

    public ApplicantDto(Applicant applicant){
        id = applicant.getId();
        applicantIdentify = applicant.getApplicantIdentify();
        applicantNickname = applicant.getApplicantNickname();
        applyStatus = applicant.getApplyStatus();
        directDonationId = applicant.getDirectDonation().getId();
    }
}
