import com.longhair.bloodrecovery.api.RankApiController;
import com.longhair.bloodrecovery.dto.RankDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Scheduler {
    //여기서 컨트롤러에 있는 RestTemplate을 불러!

    private final RankApiController rankApiController;

    @Scheduled(cron = "0 0 0/1 * * *")    // 1시간마다
    public List<RankDto> RankRenew() throws Exception {
        return rankApiController.getRankApi();
    }

}


