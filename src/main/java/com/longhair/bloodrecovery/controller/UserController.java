package com.longhair.bloodrecovery.controller;


import com.longhair.bloodrecovery.dto.*;
import com.longhair.bloodrecovery.domain.Point;
import com.longhair.bloodrecovery.domain.User;
import com.longhair.bloodrecovery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/idCheck/{userId}")
    public ResponseEntity<Result> idCheck(@PathVariable("userId")String userId){
        return new ResponseEntity<>(new Result(userService.checkId(userId)), HttpStatus.OK);
    }

    @GetMapping("/nicknameCheck/{nickname}")
    public ResponseEntity<Result> nicknameCheck(@PathVariable("nickname")String nickname){
        return new ResponseEntity<>(new Result(userService.checkNickname(nickname)), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(new Result(userService.login(loginDto.getId(), loginDto.getPassword())), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public void dropUser(@PathVariable("userId")String userId){
        userService.deleteUser(userId);
    }

    @PostMapping("/idFind")
    public ResponseEntity<String> idFind(@RequestBody FindDto findDto){
        return new ResponseEntity<>(userService.searchId(findDto.getName(), findDto.getPersonalNumber()), HttpStatus.OK);
    }

    @PostMapping("/pwReset")
    public ResponseEntity<Result> pwReset(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(new Result(userService.resetPassword(loginDto.getId(), loginDto.getPassword())), HttpStatus.OK);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserInfoDto> getUserInfo(@PathVariable("userId")String userId){
        return new ResponseEntity<>(userService.getUserInfo(userId), HttpStatus.OK);
    }

    @PutMapping("/info")
    public ResponseEntity<UserInfoDto> putUserInfo(@RequestBody UserPutDto userPutDto){
        return new ResponseEntity<>(userService.updateUserInfo(userPutDto), HttpStatus.OK);
    }

    @PutMapping("/point")
    public ResponseEntity<Result> changePoint(@RequestBody PointDto pointDto){
        return new ResponseEntity<>(new Result(userService.changePoint(pointDto)), HttpStatus.OK);
    }

    @GetMapping("/point/{userId}")
    public ResponseEntity<List<Point>> getPoint(@PathVariable("userId")String userId){
        return new ResponseEntity<>(userService.getPoint(userId), HttpStatus.OK);
    }

    @GetMapping("/ban/{userId}")
    public ResponseEntity<User> banUser(@PathVariable("userId")String userId){
        return new ResponseEntity<>(userService.banUser(userId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserInfoDto>> getUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
