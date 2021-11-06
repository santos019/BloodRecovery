package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.entity.Donation;
import com.longhair.bloodrecovery.entity.DonationHistory;
import com.longhair.bloodrecovery.repository.CardDonationRepository;
import com.longhair.bloodrecovery.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    //기부 요청글 등록
    public CardRequest saveCardRequest(CardRequest cardRequest){
        cardRequest.setCompleteStatus(false);
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
    public void updateCardRequsetById(CardRequest cardRequest){
        Optional<CardRequest> e = cardDonationRepository.findById(cardRequest.getId());

    }

//    public void updateDirectDonationById(DirectDonationUpdateDto directDonationUpdateDto){
//        System.out.println(directDonationUpdateDto.getId());
//        Optional<DirectDonation> e = directDonationRepository.findById(directDonationUpdateDto.getId());
//        if(e.isPresent()){
//            DirectDonation item = e.get();
//            item.setId(directDonationUpdateDto.getId());
//            item.setRequesterUserId(directDonationUpdateDto.getRequesterUserId());
//            item.setTitle(directDonationUpdateDto.getTitle());
//            item.setContents(directDonationUpdateDto.getContents());
//            item.setImage(directDonationUpdateDto.getImage());
//            item.setDate(directDonationUpdateDto.getDate());
//            item.setPeriodFrom(directDonationUpdateDto.getPeriodFrom());
//            item.setPeriodTo(directDonationUpdateDto.getPeriodTo());
//            item.setCompleteStatus(directDonationUpdateDto.getCompleteStatus());
//            directDonationRepository.save(item);
//            System.out.println("업데이트 됨");
//        }
//    }



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


    //기부자 목록 조회 => 기부 요청글 밑에 출력

    //기부 요청글 등록

    //기부 요청글 수정

    //기부 요청글 삭제

}
