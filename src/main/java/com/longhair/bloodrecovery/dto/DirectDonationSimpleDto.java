package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class DirectDonationSimpleDto {
    private Long id;
    private String requesterUserId;
    private String requesterNickname;
    private Integer requesterLevel;
    private String title;
    private String locationSido;
    private String locationSigungu;
    private LocalDateTime periodTo;
    private String bloodType;
    private Boolean completeStatus;

    public DirectDonationSimpleDto(DirectDonation directDonation){
        id = directDonation.getId();
        requesterUserId = directDonation.getRequesterUserId();
        requesterNickname = directDonation.getRequesterNickname();
        requesterLevel = directDonation.getRequesterLevel();
        title = directDonation.getTitle();
        locationSido = directDonation.getLocationSido();
        locationSigungu = directDonation.getLocationSigungu();
        periodTo = directDonation.getPeriodTo();
        bloodType = directDonation.getBloodType();
        completeStatus = directDonation.getCompleteStatus();
    }
}
