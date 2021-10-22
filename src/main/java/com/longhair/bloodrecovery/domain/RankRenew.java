package com.longhair.bloodrecovery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class RankRenew {

    @Id
    @GeneratedValue
    private Long id;

}
