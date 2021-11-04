package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.service.CardDonationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CardDonationController {

    private final CardDonationService cardDonationService;

    //기부 요청글 전체 조회
    @GetMapping("/requests")
    public List<CardRequest> cardRequests() {
        return cardDonationService.findAll();
    }

    //기부 특정 요청글 조회
    @GetMapping("/requests/{id}")
    public CardRequest cardRequest(@PathParam("id") Long id) {
        return cardDonationService.findById(id);
    }

    //기부하기
    @PostMapping("/requests/requestItem/{id}/donation")
    public String request_donation(  Long id , String userId, Long cardId  ) {
        cardDonationService.donate(  id, userId, cardId  );
        return "redirect:/기부주소";
    }

    //기부자 목록 조회 => 기부 요청글 밑에 출력

    //기부 요청글 등록

    //기부 요청글 수정

    //기부 요청글 삭제
}
