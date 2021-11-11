package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class RedHouse {
    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String redHouseName;
    private LocalDateTime reservationDate;
    private String donationType;
    private String time;

    private LocalDateTime date;
}
