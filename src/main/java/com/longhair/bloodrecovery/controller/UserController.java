package com.longhair.bloodrecovery.controller;


import com.longhair.bloodrecovery.domain.Clause;
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


    @GetMapping("/clause")
    public ResponseEntity<List<Clause>> getClause(){
        return new ResponseEntity<>(userService.getClauseList(), HttpStatus.OK);
    }

    @PostMapping("/clause")
    public void postClause(){

    }

    @PostMapping("/registry")
    public void registry(){

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
