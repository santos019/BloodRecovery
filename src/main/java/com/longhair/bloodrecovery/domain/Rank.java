package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "ranking")
public class Rank {

    @Id @GeneratedValue
    @Column(name = "ranking_id")
    private Long id;

//    private int rank;
    private LocalDateTime renewDate;

    //User
    private Long userId;
    private String userNickname;
    private String userProfile;
    private int userPoint;

    public Rank(RankRenew rankRenew){
        this.userId = rankRenew.getUserId();
        this.userNickname = rankRenew.getUserNickname();
        this.userPoint = rankRenew.getUserPoint();
        this.userProfile = rankRenew.getUserProfile();
    }

}
