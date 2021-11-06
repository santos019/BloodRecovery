package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.entity.Donation;
import com.longhair.bloodrecovery.service.CardDonationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //기부 요청글 등록
    @PostMapping("/requests/requestItem")
    public ResponseEntity<CardRequest> postRequestItem(@RequestBody CardRequest cardRequest){
        return new ResponseEntity<>(cardDonationService.saveCardRequest(cardRequest), HttpStatus.OK);
    }

    //기부 요청글 수정



//    @PutMapping("/directedItem/{id}")
//    public void putDirectedItem(@RequestBody DirectDonationUpdateDto directDonationUpdateDto, @PathVariable("id") Long id){
//        directDonationUpdateDto.setId(id);
//        directDonationService.updateDirectDonationById(directDonationUpdateDto);
//    }


    //기부 요청글 삭제
    @DeleteMapping("/requests/requestItem/{id}")
    public void deleteRequestItem(@PathVariable("id") Long id){
        cardDonationService.deleteCardRequestById(id);
    }

    //기부하기
    @PostMapping("/requests/requestItem/{id}/donation")
    public String request_donation(@RequestBody Donation donation) {
        cardDonationService.donate(donation);
        return "redirect:/기부요청글 주소";
    }

    //기부자 목록 조회 => 기부 요청글 밑에 출력
//    @GetMapping("/requests/requestItem/{id}/donation"){
//
//    }


}
