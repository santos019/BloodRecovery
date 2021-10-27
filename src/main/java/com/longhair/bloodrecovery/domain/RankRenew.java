package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class RankRenew {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime renewDate;

    private Long userId;
    private String userNickname;
    private String userProfile;
    private int userPoint;

}
