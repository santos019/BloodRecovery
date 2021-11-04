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

    //헌혈증
    private String code; //기부자가 기부한 헌혈증 코드
    //헌혈증 조회할때 필요한 데이터 다 있어야 하는감?

    private int giveCount; //기부한 헌혈증 갯수

    @OneToMany(mappedBy = "donation")
    private List<DonationHistory>  history = new ArrayList<>();





}
