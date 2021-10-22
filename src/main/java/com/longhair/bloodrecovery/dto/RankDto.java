package com.longhair.bloodrecovery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RankDto {

    //User에서 받아오는 애들
    private String nickname;
    private String profile;
    private int point;

    private Date renewDate; //1시간마다 갱신 날짜와 시간 => LocalDataTime? 얘를 여기서 해야하나? 디비에 저장할때 뿅 되게 못하는가..?

}


