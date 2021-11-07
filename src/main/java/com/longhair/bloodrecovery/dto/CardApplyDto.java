package com.longhair.bloodrecovery.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CardApplyDto {
    private String cardUrl;
    private String userId;
    private String code;
    private String donationType;
    private String name;
    private String birth;
    private String sex;
    private String date;

}
