package com.longhair.bloodrecovery.domain;

import lombok.Data;
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

    private Long directDonationId;
}
