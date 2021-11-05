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
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CardDonationService {

    private final CardDonationRepository cardDonationRepository;
    private final DonationRepository donationRepository;

    //기부 요청글 전체 조회
    public List<CardRequest> findAll() {
        return cardDonationRepository.findAll();
    }

    //기부 특정 요청글 조회
    public CardRequest findById(Long id) {
        Optional<CardRequest> opt = cardDonationRepository.findById(id);
        return opt.get();
    }

    //기부하기
    public Donation donate(Long id, Long requestId, String userId, String nickname, String cardId, int giveCount){

        /* 1. Donation 정보 저장 */
        Donation donation = new Donation();
        donation.setId(id);
        donation.setUserId(userId);
        donation.setCode(cardId);
        donation.setNickname(nickname);
        donation.setGiveCount(giveCount);

        /* 2. CardRequest 정보 조회 => 매핑 테이블의 외래키로 저장하기 위해서 */
        CardRequest cardRequest = new CardRequest();
        cardRequest.setId(requestId);

        DonationHistory donationHistory = new DonationHistory();
        donationHistory.setCardRequest(cardRequest);
        donationHistory.setDonation(donation);

        //기부 정보 저장
        Donation saveDonation = donationRepository.save(donation);

        return saveDonation; //여기에 이걸로 해도 되겠지..?ㅎ
    }


    //기부자 목록 조회 => 기부 요청글 밑에 출력

    //기부 요청글 등록

    //기부 요청글 수정

    //기부 요청글 삭제

}
