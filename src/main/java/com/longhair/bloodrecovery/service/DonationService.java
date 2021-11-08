package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.entity.Donation;
import com.longhair.bloodrecovery.entity.DonationHistory;
import com.longhair.bloodrecovery.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    //기부자 목록 조회 => 기부 요청글 밑에 출력
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    //기부하기
    public Donation donate(Donation donation){

        /* 1. Donation 정보 저장 */
        Donation savedonation = new Donation();
        savedonation.setId(donation.getId());
        savedonation.setUserId(donation.getUserId());
        savedonation.setCode(donation.getCode());
        savedonation.setNickname(donation.getNickname());
        savedonation.setGiveCount(donation.getGiveCount());
        savedonation.setRequestId(donation.getRequestId());

        /* 2. CardRequest 정보 조회 => 매핑 테이블의 외래키로 저장하기 위해서 */
        CardRequest cardRequest = new CardRequest();
        cardRequest.setId(cardRequest.getId());

        DonationHistory donationHistory = new DonationHistory();
        donationHistory.setCardRequest(cardRequest);
        donationHistory.setDonation(savedonation);

        //기부 정보 저장
        Donation saveDonation = donationRepository.save(donation);

        return saveDonation; //여기에 이걸로 해도 되겠지..?ㅎ
    }

    //기부했을때 포인트...부분...
//    public DirectDonation saveDirectDonation(DirectDonation directDonation){
//        RestTemplate rt = new RestTemplate();
//        String location = url + "point";
//        Map<String, Object> pointMap = new HashMap<>();
//        pointMap.put("userId", directDonation.getRequesterUserId());
//        pointMap.put("plusPoint", 0);
//        //TODO
//        //지정헌혈 헌혈 종류 상관없이 개당 50포인트 차감
//        pointMap.put("minusPoint", directDonation.getBloodMaxCount() * 50);
//        pointMap.put("breakdown", "지정헌혈 " + directDonation.getBloodMaxCount() + "개의 포인트 차감");
//        ResponseEntity<Map> result = rt.exchange(location, HttpMethod.PUT, new HttpEntity<Map>(pointMap), Map.class);
//        if(!Boolean.parseBoolean(result.getBody().get("result").toString())){
//            return new DirectDonation();
//        }
//
//        location = url + "info/" + directDonation.getRequesterUserId();
//        Map map = rt.getForObject(location, Map.class);
//        directDonation.setRequesterNickname(map.get("nickname").toString());
//        directDonation.setRequesterLevel(Integer.parseInt(map.get("level").toString()));
//
//        directDonation.setCompleteStatus(false);
//        directDonationRepository.save(directDonation);
//        return directDonation;
//    }

}
