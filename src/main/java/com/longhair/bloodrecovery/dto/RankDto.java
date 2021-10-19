package com.longhair.bloodrecovery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RankDto {

    //user에서 받아오는 애들
    private String nickname;
    private String profile;
    private int point;

    private int rank = 0 ; //받아 온 다음에 랭크 for문으로 돌려서 다시..!
    private Date renewDate;

}


