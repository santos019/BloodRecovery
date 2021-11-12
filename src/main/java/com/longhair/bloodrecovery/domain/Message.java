package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String producer;
    private String consumer;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private LocalDateTime date;
    private boolean read;
}
