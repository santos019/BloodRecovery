package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.dto.CardRequestSimpleDto;
import com.longhair.bloodrecovery.dto.CardRequestUpdateDto;
import com.longhair.bloodrecovery.dto.SearchData;
import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.entity.Donation;
import com.longhair.bloodrecovery.entity.DonationHistory;
import com.longhair.bloodrecovery.repository.CardDonationRepository;
import com.longhair.bloodrecovery.repository.DonationRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CardDonationService {

    private final CardDonationRepository cardDonationRepository;
    private final DonationRepository donationRepository;

    //검색 필터링 기능
    public List<CardRequestSimpleDto> findCardRequestAll(SearchData searchData){
        List<CardRequestSimpleDto> cardRequestSimpleDtos = new ArrayList<>();
        List<CardRequest> cardRequests = new ArrayList<>();

        switch (searchData.getSearchMode()){
            case 2: //리액트때 민정이꺼 보기 편할려고 2로 해놓음ㅎ
                cardRequests = cardDonationRepository.findCardRequestByCompleteStatus(true);
                break;
            default:
                break;
        }
        cardRequests.forEach(e -> cardRequestSimpleDtos.add(new CardRequestSimpleDto(e)));
        return cardRequestSimpleDtos;
    }

    //기부 요청글 전체 조회
    public List<CardRequest> findAll() {
        return cardDonationRepository.findAll();
    }

    //기부 특정 요청글 조회
    public CardRequest findById(Long id) {
        Optional<CardRequest> opt = cardDonationRepository.findById(id);
        return opt.get();
    }

    //기부 요청글 등록
    public CardRequest saveCardRequest(CardRequest cardRequest){

        RestTemplate rt = new RestTemplate();
        String location = "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/" + "point"; //url은 유저꺼

        Map<String, Object> pointMap = new HashMap<>();
        pointMap.put("userId", cardRequest.getUserId());
        pointMap.put("plusPoint", (cardRequest.getRequestCount() - cardRequest.getDonationCount()) * 50);
        //((요청한 헌혈증 개수 - 기부 받은 헌혈증 개수) * 50 )만큼 포인트 돌려받기
        pointMap.put("minusPoint", cardRequest.getRequestCount() * 50); //요청 수 마다 50포인트 차감
        pointMap.put("breakdown", "헌혈증기부" + cardRequest.getRequestCount() + "개의 포인트 차감");

        ResponseEntity<Map> result = rt.exchange(location, HttpMethod.PUT, new HttpEntity<>(pointMap), Map.class);
        if (!Boolean.parseBoolean(result.getBody().get("result").toString())){
            return new CardRequest();
        }

        location = "http://bloodrecovery-lb-1423483073.us-east-2.elb.amazonaws.com:8000/user/" + "info/" + cardRequest.getUserId();
        Map map = rt.getForObject(location, Map.class);
        cardRequest.setNickname(map.get("nickname").toString());
        cardRequest.setLevel(Integer.parseInt(map.get("level").toString()));
        cardRequest.setPoint(Integer.parseInt(map.get("point").toString()));

        cardRequest.setCompleteStatus(false); //완료상태가 아니다!
        cardRequest.setRequestDate(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm"))));

        cardDonationRepository.save(cardRequest);

        return cardRequest;
    }

    //기부 요청글 삭제
    public void deleteCardRequestById(Long id){
        Optional<CardRequest> item = cardDonationRepository.findById(id);
        List<Long> idList = new ArrayList<>();
        cardDonationRepository.deleteById(id);
    }
    //흐음 다 삭제해야하나....ㅎㅎㅎ
//    public void deleteDirectDonationById(Long id){
//        Optional<DirectDonation> item = directDonationRepository.findById(id);
//        List<Long> idList = new ArrayList<>();
//        if(item.isPresent()){
//            item.get().getApplicants().forEach(e -> idList.add(e.getId()));
//            applicantRepository.deleteAllById(idList);
//        }
//        directDonationRepository.deleteById(id);
//    }

    //기부 요청글 수정
    public void updateCardRequestById(CardRequestUpdateDto cardRequestUpdateDto){
        Optional<CardRequest> e = cardDonationRepository.findById(cardRequestUpdateDto.getId());
        if (e.isPresent()){
            CardRequest item = e.get();
            item.setId(cardRequestUpdateDto.getId());
            item.setUserId(cardRequestUpdateDto.getUserId());
            item.setTitle(cardRequestUpdateDto.getTitle());
            item.setContents(cardRequestUpdateDto.getContents());
            item.setImage(cardRequestUpdateDto.getImage());
            cardDonationRepository.save(item);
            System.out.println("업데이트 완료");
        }
    }


}
