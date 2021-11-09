package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.entity.CardRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardRequestSimpleDto {
    private Long id;
//    private String userId; //얘 필요한가..?
    private String nickname; //요청자 닉네임
    private Integer level; //요청자 등급
    private String title; //요청글 제목
    private int requestCount; //요청한 헌혈증 개수
    private int donationCount; //기부받은 헌혈증 개수
    private LocalDate requestDate; //기부 요청한 날짜

    public CardRequestSimpleDto(CardRequest cardRequest){
        id = cardRequest.getId();
        nickname = cardRequest.getNickname();
        level = cardRequest.getLevel();
        title = cardRequest.getTitle();
        requestCount = cardRequest.getRequestCount();
        donationCount = cardRequest.getDonationCount();
        requestDate = cardRequest.getRequestDate();
    }
}

