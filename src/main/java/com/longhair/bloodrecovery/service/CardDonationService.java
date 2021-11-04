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
    public Donation donate(Long requestId, String userId, Long cardId){

        /* 1. Donation 정보 저장 */
        Donation donation = new Donation();
        donation.setUserId(userId);
//        donation.setCode(cardId);

        /* 2. CardRequest 정보 조회 => 매핑 테이블의 외래키로 저장하기 위해서 */
        CardRequest cardRequest = new CardRequest();
        cardRequest.setId(requestId);

        DonationHistory donationHistory = new DonationHistory();
        donationHistory.setCardRequest(cardRequest);
        donationHistory.setDonation(donation);

        //기부 정보 저장
        Donation d = donationRepository.save(donation);

        return d;


    }

//    /** 주문 */
//    @Transactional
//    public Long order(Long memberId, Long itemId, int count) {
//
////엔티티 조회
//        Member member = memberRepository.findOne(memberId);
//        Item item = itemRepository.findOne(itemId);
//
////배송정보 생성
//        Delivery delivery = new Delivery();
//        delivery.setAddress(member.getAddress());
//        delivery.setStatus(DeliveryStatus.READY);
//
////주문상품 생성
//        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(),
//
//                count);
////주문 생성
//        Order order = Order.createOrder(member, delivery, orderItem);
//
////주문 저장
//        orderRepository.save(order);
//        return order.getId();
//    }

    //기부자 목록 조회 => 기부 요청글 밑에 출력

    //기부 요청글 등록

    //기부 요청글 수정

    //기부 요청글 삭제

}
