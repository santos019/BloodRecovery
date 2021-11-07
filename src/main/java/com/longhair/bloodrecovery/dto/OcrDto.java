package com.longhair.bloodrecovery.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OcrDto {
    private String code;
    private String donationType;
    private String name;
    private String birth;
    private String sex;
    private String date;
}
