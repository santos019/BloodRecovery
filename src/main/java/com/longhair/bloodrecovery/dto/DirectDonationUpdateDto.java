package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class DirectDonationUpdateDto {
    private Long id;
    private String requesterUserId;
    private String title;
    private String contents;
    private String image;
    private LocalDateTime periodFrom;
    private LocalDateTime periodTo;
    private Boolean completeStatus;

    public DirectDonationUpdateDto(Long id, String requesterUserId, String title, String contents, String image, LocalDateTime periodFrom, LocalDateTime periodTo, Boolean completeStatus) {
        this.id = id;
        this.requesterUserId = requesterUserId;
        this.title = title;
        this.contents = contents;
        this.image = image;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.completeStatus = completeStatus;
    }

    public DirectDonationUpdateDto(DirectDonation directDonation){
        id = directDonation.getId();
        requesterUserId = directDonation.getRequesterUserId();
        title = directDonation.getTitle();
        contents = directDonation.getContents();
        image = directDonation.getImage();
        periodFrom = directDonation.getPeriodFrom();
        periodTo = directDonation.getPeriodTo();
        completeStatus = directDonation.getCompleteStatus();
    }
}
