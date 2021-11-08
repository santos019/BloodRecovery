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
    public void updateCardRequestById(CardRequestUpdateDto cardRequestUpdateDto){
        Optional<CardRequest> e = cardDonationRepository.findById(cardRequestUpdateDto.getId());
        if (e.isPresent()){
            CardRequest item = e.get();
            item.setId(cardRequestUpdateDto.getId());
            item.setUserId(cardRequestUpdateDto.getUserId());
            item.setTitle(cardRequestUpdateDto.getTitle());
            item.setContexts(cardRequestUpdateDto.getContexts());
            item.setImage(cardRequestUpdateDto.getImage());
            cardDonationRepository.save(item);
            System.out.println("업데이트 완료");
        }
    }


}
