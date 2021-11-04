package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "ranking")
public class Rank {

    @Id @GeneratedValue
    @Column(name = "ranking_id")
    private Long id;

    private int userRank;

    //User
    private String userId;
    private String nickname;
    private String profile;
    private int point;

    public Rank(RankHistory rankHistory){
        this.userId = rankHistory.getUserId();
        this.nickname = rankHistory.getNickname();
        this.point = rankHistory.getPoint();
        this.profile = rankHistory.getProfile();
    }


    public Rank(){
        //생성자를 하나라도 프로그래머가 만들었다면 기본생성자는 자동으로 만들어지지 않는다.
    }

}
