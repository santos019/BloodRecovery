package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.entity.CardRequest;
import com.longhair.bloodrecovery.repository.CardDonationRepository;
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

    //기부 요청글 전체 조회
    public List<CardRequest> findAll() {
        return cardDonationRepository.findAll();
    }

    //기부 특정 요청글 조회
//    public CardRequest findById(Long id) {
//        Optional<CardRequest> opt = cardDonationRepository.findById(id);
//        return
//    }

}
