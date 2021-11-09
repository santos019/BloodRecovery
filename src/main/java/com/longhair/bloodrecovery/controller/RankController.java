package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.service.RankService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class RankController {
    private final RankService rankService;

    //전체 랭킹 조회
    @CrossOrigin("*")
    @GetMapping("/rankings")
    public  List<Rank> ranks() {
      return rankService.findAll();
    }

    //나의 랭킹 조회 -> userId로 조회
    @GetMapping("/rankings/{userId}")
    public  Rank myRank(@PathVariable("userId") String userId){
        return rankService.findOne(userId);
    }

}
