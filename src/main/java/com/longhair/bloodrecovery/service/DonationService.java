package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.entity.Donation;
import com.longhair.bloodrecovery.entity.DonationHistory;
import com.longhair.bloodrecovery.repository.CardDonationRepository;
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
    private final CardDonationRepository cardDonationRepository;

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

        // 기부 요청글 조회
        CardRequest cardRequest = cardDonationRepository.findById(donation.getRequestId()).get();

        /* 2. CardRequest 정보 조회 => 매핑 테이블의 외래키로 저장하기 위해서 */
        cardRequest.setId(cardRequest.getId());
        cardRequest.setDonationCount(cardRequest.getDonationCount() + donation.getGiveCount());//기부받은 개수만큼 추가
        if (cardRequest.getRequestCount() == cardRequest.getDonationCount()){
            cardRequest.setCompleteStatus(true);
        }//요청개수를 다 채우면 완료상태를 true로 변경

        DonationHistory donationHistory = new DonationHistory();
        donationHistory.setCardRequest(cardRequest);
        donationHistory.setDonation(savedonation);

        //기부 정보 저장
        Donation saveDonation = donationRepository.save(donation);

        return saveDonation;
    }

    //요청개수를 덜 채웠을 때 포인트 돌려받는 부분 ...



}
