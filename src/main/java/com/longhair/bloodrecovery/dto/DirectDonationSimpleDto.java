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
    private String contents;
    private String image;
    private Date date;
    private Integer locationSido;
    private Integer locationSigungu;
    private Date periodFrom;
    private Date periodTo;
    private String bloodType;
    private Integer bloodMaxCount;
    private Integer bloodCurrentCount;
    private Boolean completeStatus;

    public DirectDonationSimpleDto(DirectDonation directDonation){
        id = directDonation.getId();
        requesterId = directDonation.getRequesterId();
        requesterNickname = directDonation.getRequesterNickname();
        requesterLevel = directDonation.getRequesterLevel();
        title = directDonation.getTitle();
        contents = directDonation.getContents();
        image = directDonation.getImage();
        date = directDonation.getDate();
        locationSido = directDonation.getLocationSido();
        locationSigungu = directDonation.getLocationSigungu();
        periodFrom = directDonation.getPeriodFrom();
        periodTo = directDonation.getPeriodTo();
        bloodType = directDonation.getBloodType();
        bloodMaxCount = directDonation.getBloodMaxCount();
        bloodCurrentCount = directDonation.getBloodCurrentCount();
        completeStatus = directDonation.getCompleteStatus();
    }
}
