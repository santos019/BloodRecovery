package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Clause {
    @Id
    @GeneratedValue
    private Long id;

    private String contents;
    private Date date;
    private boolean isRequired;
}
