package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class RedHouse {
    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String redHouseName;
    private Date reservationDate;
    private String donationType;
    private String time;

    private Date date;
}
