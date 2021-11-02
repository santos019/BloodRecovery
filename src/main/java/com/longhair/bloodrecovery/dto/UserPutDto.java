package com.longhair.bloodrecovery.dto;

import lombok.Data;

@Data
public class UserPutDto {
    private String userId;
    private String password;
    private String profile;
    private String nickname;
}
