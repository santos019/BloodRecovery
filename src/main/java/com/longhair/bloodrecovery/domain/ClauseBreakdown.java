package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ClauseBreakdown {
    @Id
    @GeneratedValue
    private Long id;

    private Long clauseId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private boolean isAgree;
    private Date agreeDate;
}
