package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import com.longhair.bloodrecovery.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RankService {

    private final RankRepository rankRepository;

    //나의 랭킹 조회
    public Rank findOne(Long rankId){

        return rankRepository.findOne(rankId);

    }

    //랭킹 전체 조회
    public List<Rank> findAll(Sort rank) {
        return rankRepository.findAll();
    }

    //User에서 받아온 데이터 저장
    public void save(RankRenew rankRenew) {
        rankRepository.save(rankRenew);
    }

}
