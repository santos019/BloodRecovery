package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Notice {
    @Id
    @GeneratedValue
    private Long id;

    private String writerUserId;
    private String writerNickname;
    private int writerLevel;
    private String title;
    private String contents;
    private String image;
    private String imageUrl;
    private LocalDateTime date;
}
