package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.User;
import lombok.Data;

@Data
public class UserInfoDto {
    private String userId;
    private String name;
    private String nickname;
    private String profile;
    private int point;
    private int level;

    public UserInfoDto(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.profile = user.getProfile();
        this.point = user.getPoint();
        this.level = user.getLevel();
    }
}
