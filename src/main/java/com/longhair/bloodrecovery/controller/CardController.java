package com.longhair.bloodrecovery.controller;

import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;
import com.longhair.bloodrecovery.domain.Card;
import com.longhair.bloodrecovery.dto.CardApplyDto;
import com.longhair.bloodrecovery.dto.OcrDto;
import com.longhair.bloodrecovery.service.CardService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {
    @Autowired
    private CardService cardService;

    //헌혈증 조회
    @GetMapping("/bloodpocket/{id}")
    public List<Card> cards(@PathVariable("id") String id) {
        return cardService.findCards(id);
    }

    //헌혈증 소유자 변경
    @PutMapping("/card/{id}/{userid}")
    public Card putCardItem(@PathVariable("id") Long id, @PathVariable("userid") String userid){
        return cardService.updateCard(id, userid);
    }

    //헌혈증 등록
    @PostMapping("/card/{userid}")
    public Card save(@RequestBody Card card, @PathVariable("userid") String userid) {
        return cardService.save(card, userid);
    }

    //카드 OCR 인식
    @PostMapping("/card/ocr")
    public ResponseEntity<OcrDto> useOcr(@RequestParam("file") MultipartFile file){
        Image image = null;
        if(file.isEmpty()){
            return new ResponseEntity<>(new OcrDto(), HttpStatus.OK);
        } else {
            try{
                ByteString imgBytes = ByteString.readFrom(file.getInputStream());
                image = Image.newBuilder().setContent(imgBytes).build();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(cardService.useOcr(image), HttpStatus.OK);
    }

    @PostMapping("/card/apply")
    public ResponseEntity<Boolean> apply(@RequestBody CardApplyDto cardApplyDto){
        return new ResponseEntity<>(cardService.applyOcr(cardApplyDto), HttpStatus.OK);
    }
}


