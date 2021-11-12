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

    @Column(length = 500)
    private String title;

    @Column(length = 1000)
    private String contents;

    private String image;
    private String imageUrl;
    private LocalDateTime date;

    @OneToMany
    private List<Promotion> proJoinUsers = new ArrayList<>();
}
