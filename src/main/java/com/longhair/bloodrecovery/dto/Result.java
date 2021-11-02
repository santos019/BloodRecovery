package com.longhair.bloodrecovery.dto;

import lombok.Data;

@Data
public class Result {
    private boolean result;
    public Result(boolean result){
        this.result = result;
    }
}
