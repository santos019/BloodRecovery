package com.longhair.bloodrecovery.service;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import com.longhair.bloodrecovery.domain.Card;
import com.longhair.bloodrecovery.dto.CardApplyDto;
import com.longhair.bloodrecovery.dto.OcrDto;
import com.longhair.bloodrecovery.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CardService {
    //헌혈증조회, 추가, 파일업로드, 헌혈증 기부하기-> 다른 유저의 지갑으로 이동(이걸 어케하지....)
    private final static String url = "http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/user/info/";
    @Autowired
    private final CardRepository cardRepository;

    //헌혈증 조회
    public List<Card> findCards(String id) {
        return cardRepository.findByUserid(id);
    }

    //헌혈증 소유자 변경
    @Transactional
    public Card updateCard(Long cardid, String userid){
        Optional<Card> opt = cardRepository.findById(cardid);
        Card findCard = null;
        if(opt.isPresent()) {
            findCard = opt.get();
            findCard.setUserid(userid);
        }
        return cardRepository.save(findCard);
    }

    //헌혈증추가
    public Card save(Card card, String id){
        card.setUserid(id);
        return cardRepository.save(card);
    }

    public OcrDto useOcr(Image image){
        OcrDto ocrDto = new OcrDto();

        //OCR 초기설정
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Feature feature = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feature).setImage(image).build();
        requests.add(request);

        //OCR 작동
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            String responseString = "";
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            //결과값(String) 저장
            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    log.error(res.getError().getMessage());
                }
                // For full list of available annotations, see http://g.co/cloud/vision/docs
                for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                    log.info("Text: " + annotation.getDescription());
                    responseString += annotation.getDescription();
                }
            }
            //저장된 결과값(String) Map으로 분류
            String[] strings = responseString.split("\n");
            for(String e : strings){
                if(e.contains(":")){
                    String[] items = e.split(":");
                    String tmp = items[0].replaceAll("\\s", "");
                    String tmp2 = items[1].replaceAll("\\s", "");
                    //TODO 헌혈증 바코드값 입력 해야함.
                    switch (tmp) {
                        case "헌혈종류":
                            items[0] = "donationType";
                            ocrDto.setDonationType(tmp2);
                            break;
                        case "성명":
                            ocrDto.setName(tmp2);
                            break;
                        case "생년월일":
                            ocrDto.setBirth(tmp2);
                            break;
                        case "헌혈일자":
                            ocrDto.setDate(tmp2);
                            break;
                        case "성별":
                            ocrDto.setSex(tmp2);
                            break;
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ocrDto;
    }

    //map으로 나온 결과를 BIMS에 보내서 인증받는 메소드
    public boolean applyOcr(CardApplyDto cardApplyDto){
        //TODO
        //BIMS 인증
        boolean result = false;
        RestTemplate rt = new RestTemplate();
        Map item = rt.getForObject(url + cardApplyDto.getUserId(), Map.class);
        if(item.get("name").equals(cardApplyDto.getName())){
            //BIMS 인증하기
            result = true;
        }
        return result;
    }
}
