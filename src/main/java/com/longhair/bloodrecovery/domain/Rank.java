package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "ranking")
public class Rank {

    @Id @GeneratedValue
    @Column(name = "ranking_id")
    private Long id;

    private int rank;
    private Date renewDate;

    //User
    private Long userId;
    private String userNickname;
    private String userProfile;
    private int userPoint;


}
