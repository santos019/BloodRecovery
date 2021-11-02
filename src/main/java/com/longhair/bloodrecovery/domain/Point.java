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

    private String userId;
    private int plusPoint;
    private int minusPoint;
    private int currentPoint;
    private Date date;
    private String breakdown;
}
