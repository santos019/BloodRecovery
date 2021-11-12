package com.longhair.bloodrecovery.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplyDto {
    private String userId;
    private LocalDateTime date;
}
