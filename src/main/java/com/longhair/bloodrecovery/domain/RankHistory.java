package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class RankHistory {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime renewDate;

    private String userId;
    private String nickname;
    private String profile;
    private int point;

}
