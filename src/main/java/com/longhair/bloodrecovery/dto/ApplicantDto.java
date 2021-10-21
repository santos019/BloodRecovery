package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.Applicant;
import lombok.Data;

@Data
public class ApplicantDto {
    private Long id;
    private String applicantNickname;
    private Boolean applyStatus;
    private Long directDonationId;

    public ApplicantDto(Applicant applicant){
        id = applicant.getId();
        applicantNickname = applicant.getApplicantNickname();
        applyStatus = applicant.getApplyStatus();
        directDonationId = applicant.getDirectDonationId();
    }
}
