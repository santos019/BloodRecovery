package com.longhair.bloodrecovery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Donation {

    @Id
    @GeneratedValue
    @Column(name = "donation_id")
    private Long id;

    //User
    private String userId; //기부자 아이디
    private String nickname; //기부자 닉네임
    private Integer point; //기부자 포인트

    //헌혈증
    private String code; //기부자가 기부한 헌혈증 코드

    private int giveCount; //기부한 헌혈증 갯수

    //요청글 아이디
//    private Long requestId;

    //기부요청(CardRequest)이랑 다대일
    @ManyToOne
    @JoinColumn(name = "request_id")
    private CardRequest cardRequest;





}
