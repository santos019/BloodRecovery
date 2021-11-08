package com.longhair.bloodrecovery.dto;

import lombok.Data;

@Data
public class SearchData {
    private boolean status = false;  // 2

    public int getSearchMode(){
        int result = 0;
        if (status){
            result += 2;
        }
        System.out.println(result);
        return result;
    }
}

//@Data
//public class SearchData {
//    private String bloodType = null;    // 1
//    private boolean status = false;     // 2
//    private int sido = 0;               // 4
//    private int sigungu = 0;
//
//    public int getSearchMode(){
//        int result=0;
//        if(!(bloodType == null || bloodType.trim().isEmpty())){
//            result += 1;
//        }
//        if(status){
//            result += 2;
//        }
//        if(sido > 0 && sigungu > 0){
//            result += 4;
//        }
//        System.out.println(result);
//        return result;
//    }
//}
