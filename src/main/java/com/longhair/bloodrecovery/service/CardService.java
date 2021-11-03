package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Card;
import com.longhair.bloodrecovery.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CardService {
    //헌혈증조회, 추가, 파일업로드, 헌혈증 기부하기-> 다른 유저의 지갑으로 이동(이걸 어케하지....)

    @Autowired
    private final CardRepository cardRepository;

    //헌혈증 조회
    public List<Card> findCards(Long id) {
        return cardRepository.findByUserid(id);
//        return cardRepository.findAll();
    }

    //헌혈증 소유자 변경
    @Transactional
    public Card updateCard(Long cardId, Long userId){
        Optional<Card> opt = cardRepository.findById(cardId);
        Card findCard = null;
        if(opt.isPresent()) {
            findCard = opt.get();
            findCard.setUserid(userId);
        }
        return cardRepository.save(findCard);
    }


    //단건조회
    public Card findOne(Long cardId){
        Optional<Card> opt = cardRepository.findById(cardId);
        Card card = null;
        if(opt.isPresent()) {
            card = opt.get();
        }
        return card;
    }


    //헌혈증추가
    public Card save(Card card, Long id){
    card.setUserid(id);
//        card.setImage(card.getImage());
        return cardRepository.save(card);
    }

//    //이미지추가
//    public void save(Card card) {
//        Card c = new Card();
//        c.setImage(card.getImage());
//
//        cardRepository.save(c);
//    }






}
