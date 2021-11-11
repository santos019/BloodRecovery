package com.longhair.bloodrecovery;

import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import com.longhair.bloodrecovery.service.DirectDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {
    @Autowired
    private DirectDonationRepository directDonationRepository;

    @Autowired
    private DirectDonationService directDonationService;

    @Scheduled(cron = "0 0 0 * * *")          //매일 0시에 작동
    //@Scheduled(cron = "0/10 * * * * *")   //10초마다 작동 테스트용
    @Transactional
    public void directScheduler(){
        LocalDateTime date = LocalDateTime.now();
        List<DirectDonation> directDonations = directDonationRepository.findDirectDonationsByPeriodToBefore(date);
        if(directDonations.size() > 0){
            directDonations.forEach(e -> {
                directDonationService.changeComplete(e);
                e.setCompleteStatus(true);
            });
            directDonationRepository.saveAll(directDonations);
        }
    }
}
