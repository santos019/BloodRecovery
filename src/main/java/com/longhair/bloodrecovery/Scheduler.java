package com.longhair.bloodrecovery;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankHistory;
import com.longhair.bloodrecovery.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class Scheduler {
    private final static String userUrl = "http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/user";
    private final static String messageUrl = "http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/notice/message";
    @Autowired
    private final RankService rankService;

    //User에서 포인트로 1시간마다 정렬된 데이터 받아옴
    @Scheduled(cron = "0 0 0/1 * * *")//1시간마다 갱신
//    @Scheduled(cron = "0 0/10 * * * *")//10분마다 갱신
//    @Scheduled(cron = "0/30 * * * * *")//10초마다 갱신
    //@Scheduled(cron = "0 0 0 * * ?")//매일 정각
    //==========RestTemplate===========//
    public void RankRenewApi() {
        RestTemplate rt = new RestTemplate();
        RankHistory[] list = rt.getForObject(userUrl, RankHistory[].class);
        String firstUserId = "";
        //나중에 User url로 바꿔야함~_~

        //Rank 데이터 전체 삭제
        rankService.deleteAll();

        for (int i = 0; i < list.length; i++)  {
            RankHistory rh = list[i]; //배열로
            Rank r = new Rank(rh);
            rankService.save(rh); //RankRenew로 저장
            rankService.save(r); //Rank로 저장
        }

        //userRank 컬럼 업데이트
        rankService.updateRank();

    }

    //1위에게 상품 안내 메시지를 전송하는 스케쥴러
    @Scheduled(cron = "0 0 0 1 * *") //매월 1일마다  0 15 10 15 * ? 매달 15일 오전 10시 15분
    public void winnerSchedule(){
        List<Rank> items = rankService.findAll();

        // ranking 테이블에 데이터가 있을 경우
        if(!items.isEmpty()){
            // ranking 테이블 데이터 모두를 검사하여 1위만 찾아내서 메시지 전송
            items.forEach(e -> {
                if(e.getUserRank() >= 1){
                    sendMessage(e.getUserId());
                }
            });
        }
    }

    private void sendMessage(String consumer){
        RestTemplate rt = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("producer", "admin");
        map.put("consumer", consumer);
        map.put("title", "1등 달성을 축하드립니다.");
        map.put("contents", "이번 달 1위를 축하드립니다.\n감사의 의미로 소정의 상품을 드리고자 하니, 다음과 같은 양식으로 이메일 부탁드립니다.\n" +
                "성명, 연락처, 주소, ooooo@ooo.com");
        rt.postForObject(messageUrl, map, Map.class);
    }
}


