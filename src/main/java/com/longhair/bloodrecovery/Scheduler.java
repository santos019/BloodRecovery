package com.longhair.bloodrecovery;

import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {
    @Autowired
    private DirectDonationRepository directDonationRepository;

    @Scheduled(cron = "0 0 0 * * *")          //매일 0시에 작동
    //@Scheduled(cron = "0/10 * * * * *")   //10초마다 작동 테스트용
    @Transactional
    public void directScheduler(){
        long milliseconds = System.currentTimeMillis();
        Date date = new Date(milliseconds);
        List<DirectDonation> directDonations = directDonationRepository.findDirectDonationsByPeriodToBefore(date);
        if(directDonations.size() > 0){
            directDonations.forEach(e -> e.setCompleteStatus(true));
            directDonationRepository.saveAll(directDonations);
        }
    }
}
