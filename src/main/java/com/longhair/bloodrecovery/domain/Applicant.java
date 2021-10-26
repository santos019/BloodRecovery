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

    private String applicantIdentify;

    private String applicantNickname;

    private Boolean applyStatus;

    @ManyToOne
    @JoinColumn(name="DIRECTDONATION_ID")
    private DirectDonation directDonation;

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", applicantIdentify='" + applicantIdentify + '\'' +
                ", applicantNickname='" + applicantNickname + '\'' +
                ", applyStatus=" + applyStatus +
                '}';
    }
}
