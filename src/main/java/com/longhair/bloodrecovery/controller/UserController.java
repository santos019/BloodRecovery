package com.longhair.bloodrecovery.controller;


import com.longhair.bloodrecovery.domain.Clause;
import com.longhair.bloodrecovery.domain.ClauseBreakdown;
import com.longhair.bloodrecovery.domain.User;
import com.longhair.bloodrecovery.service.PointService;
import com.longhair.bloodrecovery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PointService pointService;

    @GetMapping("/clause")
    public ResponseEntity<List<Clause>> getClause(){
        return new ResponseEntity<>(userService.getClauseList(), HttpStatus.OK);
    }

    @PostMapping("/clause")
    public ResponseEntity<ClauseBreakdown> postClause(@RequestBody ClauseBreakdown clauseBreakdown){
        return new ResponseEntity<>(userService.postClauseBreakdown(clauseBreakdown), HttpStatus.OK);
    }

    @PostMapping("/registry")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public void login(){

    }

    @DeleteMapping("")
    public void dropUser(){

    }

    @PostMapping("/idfind")
    public void idFind(){

    }

    @PostMapping("/pwreset")
    public void pwReset(){

    }

    @GetMapping("/info")
    public void getUserInfo(){

    }

    @PutMapping("/info")
    public void putUserInfo(){

    }
    @PostMapping("/point")
    public void changePoint(){

    }

    @GetMapping("/point")
    public void getPoint(){

    }
}
