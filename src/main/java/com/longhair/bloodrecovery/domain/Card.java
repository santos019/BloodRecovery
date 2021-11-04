package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "cards")
@Getter @Setter
public class Card {


    @Id @GeneratedValue
    @Column(name = "CARD_ID")
    private Long id;
    private String code;
    private String image;



    private String userid;


//
//    public void changeUser(User user) {
//        this.user = user;
//        user.getCards().add(this);
//    }
}
