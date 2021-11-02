package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

import java.util.Date;

@Data
public class DirectDonationSimpleDto {
    private Long id;
    private Long requesterId;
    private String requesterNickname;
    private Integer requesterLevel;
    private String title;
    private Integer locationSido;
    private Integer locationSigungu;
    private Date periodTo;
    private String bloodType;
    private Boolean completeStatus;

    public DirectDonationSimpleDto(DirectDonation directDonation){
        id = directDonation.getId();
        requesterId = directDonation.getRequesterId();
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
