package com.longhair.bloodrecovery.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Notice {
    @Id
    @GeneratedValue
    private Long id;

    private String writerUserId;
    private String writerNickname;
    private int writerLevel;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private String image;
    private String imageUrl;
    private LocalDateTime date;

    @Column(columnDefinition = "TEXT")
    private String proJoinUsers;
}
