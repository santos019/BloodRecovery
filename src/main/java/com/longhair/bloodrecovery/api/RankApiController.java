package com.longhair.bloodrecovery.api;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.dto.RankDto;
import com.longhair.bloodrecovery.service.RankService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RankApiController {

    private final RankService rankService;

    @GetMapping("/ranking")
    //==========resttemplate로 바꾸기============//
    public Result rankApi(){
        List<Rank> findRank = rankService.findAll();
        List<RankDto> collect = findRank.stream()  //자바8...
                .map(r -> new RankDto(r.getNickname(),r.getProfile(),r.getPoint(),r.getRank(),r.getRenewDate()))
                .collect(Collectors.toList());

        return new Result(collect); //이렇게 감싸주는게 좋음! 안하면 그냥 배열로 나오는거임
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

}
