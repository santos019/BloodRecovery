package com.longhair.bloodrecovery.dto;

import lombok.Data;

@Data
public class PointDto {
    private String userId;
    private int plusPoint;
    private int minusPoint;
    private int currentPoint;
    private String breakdown;
}
