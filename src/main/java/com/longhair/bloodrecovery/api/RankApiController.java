package com.longhair.bloodrecovery.api;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.dto.RankDto;
import com.longhair.bloodrecovery.repository.RankRepository;
import com.longhair.bloodrecovery.service.RankService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RankApiController {

    private final RankService rankService;
    private final RankRepository rankRepository;

    //User에서 포인트로 정렬된 데이터 받아옴
    @GetMapping("/ranking/api") //설계서 추가해..
    //==========RestTemplate===========//
    public List<RankRenew> RankRenewApi() {
        RestTemplate rt = new RestTemplate();
        List<RankRenew> list = rt.getForObject("민정이 컴퓨터 아이피", List.class);
        return rankRepository.save(); //rankRepository 바로 불러오자! 어떻게..?ㅎ 엔티티로 어떻게 만들지..?
    }

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
