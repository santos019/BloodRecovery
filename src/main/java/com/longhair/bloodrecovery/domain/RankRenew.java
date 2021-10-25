package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class RankRenew {
    //User한테 받아온 내용을 어떻게 엔티티로 하지..

    @Id
    @GeneratedValue
    private Long id;

}
