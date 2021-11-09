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
//    private int requestCount; //요청한 헌혈증 개수 ->이미 받은 애들은? ㅇ ㅓ 청일이 이거 수정 안되게 헀네..!
//    private LocalDate requestDate; //기부 요청한 날짜 (수정 날짜로?)
//    private Boolean completeStatus; //요청글 상태 애도...? 이제 필요없으면 그냥 삭제하면 안되나 ㅎㅎ;;


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
