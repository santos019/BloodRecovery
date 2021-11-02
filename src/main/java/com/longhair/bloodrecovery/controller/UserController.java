package com.longhair.bloodrecovery.controller;


import com.longhair.bloodrecovery.Result;
import com.longhair.bloodrecovery.domain.Point;
import com.longhair.bloodrecovery.domain.User;
import com.longhair.bloodrecovery.dto.PointDto;
import com.longhair.bloodrecovery.dto.UserInfoDto;
import com.longhair.bloodrecovery.dto.UserPutDto;
import com.longhair.bloodrecovery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/idCheck")
    public ResponseEntity<Result> idCheck(@RequestParam("id")String id){
        return new ResponseEntity<>(new Result(userService.checkId(id)), HttpStatus.OK);
    }

    @PostMapping("/nicknameCheck")
    public ResponseEntity<Result> nicknameCheck(@RequestParam("nickname")String nickname){
        return new ResponseEntity<>(new Result(userService.checkNickname(nickname)), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestParam("id")String userId, @RequestParam("password")String password){
        return new ResponseEntity<>(new Result(userService.login(userId, password)), HttpStatus.OK);
    }

    @DeleteMapping("/")
    public void dropUser(@RequestParam("id")String userId){
        userService.deleteUser(userId);
    }

    @PostMapping("/idFind")
    public ResponseEntity<String> idFind(@RequestParam("name")String name, @RequestParam("personalNumber")String personalNumber){
        return new ResponseEntity<>(userService.searchId(name, personalNumber), HttpStatus.OK);
    }

    @PostMapping("/pwReset")
    public ResponseEntity<Result> pwReset(@RequestParam("id")String userId, @RequestParam("password")String password){
        return new ResponseEntity<>(new Result(userService.resetPassword(userId, password)), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<UserInfoDto> getUserInfo(@RequestParam("id")String userId){
        return new ResponseEntity<>(userService.getUserInfo(userId), HttpStatus.OK);
    }

    @PutMapping("/info")
    public ResponseEntity<UserInfoDto> putUserInfo(@RequestBody UserPutDto userPutDto){
        return new ResponseEntity<>(userService.updateUserInfo(userPutDto), HttpStatus.OK);
    }

    @PutMapping("/point")
    public ResponseEntity<Integer> changePoint(@RequestBody PointDto pointDto){
        return new ResponseEntity<>(userService.changePoint(pointDto), HttpStatus.OK);
    }

    @PostMapping("/point")
    public ResponseEntity<List<Point>> getPoint(@RequestParam("id")String userId){
        return new ResponseEntity<>(userService.getPoint(userId), HttpStatus.OK);
    }
}
