package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class DirectDonationDto {
    private Long id;
    private String requesterUserId;
    private String requesterNickname;
    private Integer requesterLevel;
    private String title;
    private String contents;
    private String image;
    private LocalDateTime date;
    private String locationSido;
    private String locationSigungu;
    private LocalDateTime periodFrom;
    private LocalDateTime periodTo;
    private String bloodType;
    private Integer bloodMaxCount;
    private Integer bloodCurrentCount;
    private Boolean completeStatus;
    private List<String> applicants = new ArrayList<>();

    public DirectDonationDto(DirectDonation directDonation){
        id = directDonation.getId();
        requesterUserId = directDonation.getRequesterUserId();
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
        directDonation.getApplicants().forEach(e -> applicants.add(e.getApplicantNickname()));
    }
}
