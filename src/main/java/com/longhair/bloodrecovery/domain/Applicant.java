package com.longhair.bloodrecovery.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Applicant {
    @Id
    @GeneratedValue
    @Column(name="APPLICANT_ID")
    private Long id;

    private String applicantNickname;

    private Boolean applyStatus;

    @ManyToOne
    @JoinColumn(name="DIRECTDONATION_ID", updatable = false)
    private DirectDonation directDonation;
}
