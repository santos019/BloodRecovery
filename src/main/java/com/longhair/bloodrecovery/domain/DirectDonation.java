package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class DirectDonation {
    @Id
    @GeneratedValue
    @Column(name="DIRECTDONATION_ID")
    private Long id;

    private String requesterUserId;
    private String requesterNickname;
    private Integer requesterLevel;

    private String title = "";
    private String contents = "";
    private String image = "";
    private LocalDateTime date;

    private String locationSido = "";
    private String locationSigungu = "";

    private LocalDateTime periodFrom;
    private LocalDateTime periodTo;

    private String bloodType = "";
    private Integer bloodMaxCount = 0;
    private Integer bloodCurrentCount = 0;

    private Boolean completeStatus = false;

    private String patientName = "";
    private String hospitalName = "";
    private String roomNumber = "";
    private String phoneNumber = "";

    @OneToMany(mappedBy="directDonation")
    private List<Applicant> applicants = new ArrayList<>();


}
