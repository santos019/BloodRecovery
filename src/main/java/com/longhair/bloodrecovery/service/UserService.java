package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Point;
import com.longhair.bloodrecovery.domain.User;
import com.longhair.bloodrecovery.dto.PointDto;
import com.longhair.bloodrecovery.dto.UserInfoDto;
import com.longhair.bloodrecovery.dto.UserPutDto;
import com.longhair.bloodrecovery.repository.PointRepository;
import com.longhair.bloodrecovery.repository.UserRepository;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PointRepository pointRepository;


    @Transactional
    public boolean checkId(String id){
        return userRepository.findUserByUserId(id) != null;
    }

    @Transactional
    public boolean checkNickname(String nickname){
        return userRepository.findUserByNickname(nickname) != null;
    }

    @Transactional
    public User registerUser(User user){
        user.setPoint(0);
        user.setLevel(1);
        userRepository.save(user);
        registerPoint(user.getUserId(), 1000);
        return user;
    }

    @Transactional
    public void registerPoint(String userId, int point){
        PointDto pointDto = new PointDto();
        pointDto.setUserId(userId);
        pointDto.setPlusPoint(point);
        pointDto.setCurrentPoint(userRepository.findUserByUserId(userId).getPoint());
        pointDto.setBreakdown("회원가입 축하 포인트");
        changePoint(pointDto);
    }
    @Transactional
    public boolean login(String userId, String password){
        return password.equals(userRepository.findUserByUserId(userId).getPassword());
    }

    @Transactional
    public void deleteUser(String userId){
        userRepository.deleteUserByUserId(userId);
    }

    @Transactional
    public String searchId(String name, String personalNumber){
        return userRepository.findUserByNameAndPersonalNumber(name, personalNumber).getUserId();
    }

    @Transactional
    public boolean resetPassword(String userId, String password){
        User user = userRepository.findUserByUserId(userId);
        user.setPassword(password);
        return userRepository.save(user) != null;
    }

    @Transactional
    public UserInfoDto getUserInfo(String userId){
        return new UserInfoDto(userRepository.findUserByUserId(userId));
    }

    @Transactional
    public UserInfoDto updateUserInfo(UserPutDto userPutDto){
        User user = userRepository.findUserByUserId(userPutDto.getUserId());
        if(userPutDto.getPassword() != null){
            user.setPassword(userPutDto.getPassword());
        }
        if(userPutDto.getProfile() != null){
            user.setProfile(userPutDto.getProfile());
        }
        if(userPutDto.getNickname() != null){
            user.setNickname(userPutDto.getNickname());
        }

        return new UserInfoDto(userRepository.save(user));
    }

    public Integer changePoint(PointDto pointDto){
        User user = userRepository.findUserByUserId(pointDto.getUserId());
        Point point = new Point();
        point.setUserId(pointDto.getUserId());
        point.setPlusPoint(pointDto.getPlusPoint());
        point.setMinusPoint(pointDto.getMinusPoint());
        int crntPoint = user.getPoint() + point.getPlusPoint() - point.getMinusPoint();
        point.setCurrentPoint(crntPoint);
        point.setBreakdown(pointDto.getBreakdown());
        point.setDate(new Date());
        user.setPoint(crntPoint);

        userRepository.save(user);
        pointRepository.save(point);

        return crntPoint;
    }

    public List<Point> getPoint(String userId){
        return pointRepository.findAllByUserId(userId);
    }
}
