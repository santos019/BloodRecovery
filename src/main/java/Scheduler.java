import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Scheduler {

    private final RankService rankService;

    //User에서 포인트로 정렬된 데이터 받아옴
    @Scheduled(cron = "0 0 0/1 * * *")//1시간마다 갱신
    @GetMapping("/ranking/api") //설계서 추가해..
    //==========RestTemplate===========//
    public List<RankRenew> RankRenewApi() {
        RestTemplate rt = new RestTemplate();
        List<RankRenew> list = rt.getForObject("민정이 컴퓨터 아이피", List.class);

        for (int i = 0; i < list.size(); i++) {
            RankRenew rr = list.get(i);
            rankService.save(rr);
        }

        return list; //rankRepository
    }

}


