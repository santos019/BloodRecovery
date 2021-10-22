package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

import java.util.Date;

@Data
public class DirectDonationUpdateDto {
    private Long id;
    private String requesterId;
    private String title;
    private String contents;
    private String image;
    private Date date;
    private Date periodFrom;
    private Date periodTo;
    private Boolean completeStatus;

    public DirectDonationUpdateDto(DirectDonation directDonation){
        id = directDonation.getId();
        requesterId = directDonation.getRequesterId();
        title = directDonation.getTitle();
        contents = directDonation.getContents();
        image = directDonation.getImage();
        date = directDonation.getDate();
        periodFrom = directDonation.getPeriodFrom();
        periodTo = directDonation.getPeriodTo();
        completeStatus = directDonation.getCompleteStatus();
    }
}
