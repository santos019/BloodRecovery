package com.longhair.bloodrecovery;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Scheduler {

    @Autowired
    private final RankService rankService;

    //User에서 포인트로 1시간마다 정렬된 데이터 받아옴 통째로
//    @Scheduled(cron = "0 0 0/1 * * *")//1시간마다 갱신
    @Scheduled(cron = "0/10 * * * * *")//10초마다 갱신
    //==========RestTemplate===========//
    public void RankRenewApi() {
        log.error("run!!");
        RestTemplate rt = new RestTemplate();
        List<RankRenew> list = rt.getForObject("청일이 컴퓨터 아이피", List.class);

        //갱신된 데이터 저장
        for (int i = 0; i < list.size(); i++) {
            RankRenew rr = list.get(i);
            Rank r = new Rank(rr);
            rankService.save(rr);
            rankService.save(r);
        }


    }


}


