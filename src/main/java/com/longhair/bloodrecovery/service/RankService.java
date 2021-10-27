package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.repository.RankDao;
import com.longhair.bloodrecovery.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;
    private final RankDao rankDao;

    //나의 랭킹 조회
    public Rank findOne(Long rankId) {
        return rankRepository.findOne(rankId);
    }

    //랭킹 전체 조회
    public List<Rank> findAll() {
        return rankRepository.findAll();
    }

    //User에서 받아온 데이터 RankRenew 저장
    public void save(RankRenew rankRenew) {
        rankRenew.setRenewDate(LocalDateTime.now());
        rankRepository.save(rankRenew);
    }

    //Rank로 저장
    public void save(Rank rank) {
        rankRepository.save(rank);
    }

    public void deleteAll() {
        rankDao.deleteAll();
    }

}
