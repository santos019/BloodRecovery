package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.entity.CardRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardRequestUpdateDto {
    private Long id;
    private String userId; //요청자 아이디 =>얘가 수정되는건 아닌데 그래도 필요한가?
    private String title; //요청글 제목
    private String contents; //요청글 내용
    private String image; //요청글에 첨부하는 이미지 주소
//    private LocalDate requestDate; //기부 요청한 날짜 (수정 날짜로?)
    private Boolean completeStatus;


    public CardRequestUpdateDto(Long id, String userId, String title, String contents, String image){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.image = image;
    }

    public CardRequestUpdateDto(CardRequest cardRequest){
        id = cardRequest.getId();
        userId = cardRequest.getUserId();
        title = cardRequest.getTitle();
        contents = cardRequest.getContents();
        image = cardRequest.getImage();
    }

}
