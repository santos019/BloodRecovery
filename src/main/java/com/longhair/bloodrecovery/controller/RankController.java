package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.service.RankService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RankController {

    private final RankService rankService;

    //전체 랭킹 조회
    @GetMapping("/rankings")
    public  List<Rank> ranks() {
      return rankService.findAll();
    }

    //나의 랭킹 조회
    @GetMapping("/rankings/{id}") //설계서 추가..
    public  Rank myRank(@PathVariable("id") Long id){
        return rankService.findOne(id);
    }

}
