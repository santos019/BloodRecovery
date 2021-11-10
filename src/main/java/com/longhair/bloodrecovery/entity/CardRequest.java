package com.longhair.bloodrecovery.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Currency;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Integer level; //요청자 등급
    private Integer point; //요청자 포인트

    private String title; //요청글 제목
    private String contents; //요청글 내용
    private String image; //요청글에 첨부하는 이미지 주소
    private int requestCount; //요청한 헌혈증 개수
    private int donationCount; //기부받은 헌혈증 개수
    private LocalDateTime requestDate; //기부 요청한 날짜
    private Boolean completeStatus; //요청글 상태
    
    //기부랑 다대일 단방향

}