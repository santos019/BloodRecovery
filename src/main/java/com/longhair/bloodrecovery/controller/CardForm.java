package com.longhair.bloodrecovery.controller;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CardForm {

    @NotEmpty(message = "헌혈증서번호 입력은 필수입니다.")
    private String code;

    private String image;
}
