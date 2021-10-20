package com.longhair.bloodrecovery.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Applicant {
    @Id
    @GeneratedValue
    private Long applicantId;

    private String applicantNickname;

    private Boolean applyStatus;
}
