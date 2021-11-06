package com.longhair.bloodrecovery.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Currency;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CardRequest {

    @Id
    @GeneratedValue
    @Column(name = "request_id")
    private Long id;

    //User
    private String userId; //요청자 아이디
    private String nickname; //요청자 닉네임
    private String level; //요청자 등급
    //포인트도 필요한가?

    private String title; //요청글 제목
    private String contexts; //요청글 내용
    private String image; //요청글에 첨부하는 이미지 주소
    private int requestCount; //요청한 헌혈증 개수
    private int donationCount; //기부받은 헌혈증 개수
    private LocalDate requestDate; //기부 요청한 날짜
    private Boolean completeStatus; //요청글 상태
    
    //기부 히스토리랑 다대일
    @OneToMany(mappedBy = "cardRequest")
    private List<DonationHistory> history = new ArrayList<>();


}