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

    private int rank; //정렬된 데이터를 받아와야함

    private Date renewDate; //1시간마다 갱신 날짜와 시간 => LocalDataTime?
}


