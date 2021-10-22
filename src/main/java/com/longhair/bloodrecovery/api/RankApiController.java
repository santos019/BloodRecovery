package com.longhair.bloodrecovery.api;

import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.dto.RankDto;
import com.longhair.bloodrecovery.repository.RankRepository;
import com.longhair.bloodrecovery.service.RankService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankApiController {

    private final RankService rankService;
    private final RankRepository rankRepository;

    @GetMapping("/ranking")
    //==========RestTemplate===========//
    //User에서 포인트로 정렬된 데이터 받아옴
    public List<RankRenew> RankRenewApi() {
        RestTemplate rt = new RestTemplate();
        List<RankRenew> list = rt.getForObject("민정이 컴퓨터 아이피", List.class);
        return rankRepository.save(); //rankRepository 바로 불러오자! 어떻게..?ㅎ
    }

//    @GetMapping 랭킹 조회하는 api 따로 작성해야함!
}
