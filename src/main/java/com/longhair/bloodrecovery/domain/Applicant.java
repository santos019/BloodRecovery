package com.longhair.bloodrecovery.domain;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Applicant {
    @Id
    @GeneratedValue
    @Column(name="APPLICANT_ID")
    private Long id;

    private String applicantIdentify;
    private String applicantNickname;
    private LocalDateTime date;
    private LocalDateTime applyDate;
    private Boolean applyStatus = false;

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
