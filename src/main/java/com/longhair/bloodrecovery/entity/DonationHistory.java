package com.longhair.bloodrecovery.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class DonationHistory {

    @Id
    @GeneratedValue
    private Long id;

//    private Long requestId; //요청 아이디
//    private Long donationId; //기부 아이디

    //User
    private String userId; //기부자 아이디
    private String nickname; //기부자 닉네임
    private int point; //기부해서 받은 포인트 =>굳이 적어야하나..?

    //얘를 여기에만..?아니면 둘다..?
    private int giveCount; //기부한 헌혈증 갯수

    private LocalDate donateDate; //기부한 날짜

    //기부요청(CardRequest)이랑 다대일
    @ManyToOne
    @JoinColumn(name = "request_id")
    private CardRequest cardRequest;

    //기부(Donation)랑 다대일
    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;
}
