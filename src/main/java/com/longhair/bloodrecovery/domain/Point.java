package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class Point {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    private Long plusPoint;
    private Long minusPoint;
    private Date date;
    private String breakdown;
}
