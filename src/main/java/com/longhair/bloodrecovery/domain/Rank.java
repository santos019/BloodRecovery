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

    @Transient //컬럼으로 안 만듦
    private int rank;

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
    public Rank(){
        //생성자를 하나라도 프로그래머가 만들었다면 기본생성자는 자동으로 만들어지지 않는다.
    }

}
