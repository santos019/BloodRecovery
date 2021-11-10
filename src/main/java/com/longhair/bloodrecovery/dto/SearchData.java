package com.longhair.bloodrecovery.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class SearchData {
    private String bloodType = null;    // 1
    private boolean status = false;     // 2
    private String sido = null;               // 4
    private String sigungu = null;

    public int getSearchMode(){
        int result=0;
        if(!bloodType.isBlank()){
            result += 1;
        }
        if(status){
            result += 2;
        }
        if(!sido.isBlank() && !sigungu.isBlank()){
            result += 4;
        }
        log.info("filtering mode is " + result);
        return result;
    }
}
