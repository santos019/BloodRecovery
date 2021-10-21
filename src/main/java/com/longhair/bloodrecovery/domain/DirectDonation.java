package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class DirectDonation {
    @Id
    @GeneratedValue
    @Column(name="DIRECTDONATION_ID")
    private Long id;

    private String requesterId;
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

    private String patientName;
    private String hospitalName;
    private String roomNumber;

    @OneToMany
    @JoinColumn(name="DIRECTDONATION_ID")
    private List<Applicant> applicants = new ArrayList<>();
}
