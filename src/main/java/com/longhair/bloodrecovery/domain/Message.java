package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String producer;
    private String consumer;
    private String title;
    private String contents;
    private Date date;
    private boolean read;
}
