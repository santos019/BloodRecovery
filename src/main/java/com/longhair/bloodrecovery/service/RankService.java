package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.repository.RankRepository;
import lombok.RequiredArgsConstructor;
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
    public List<Rank> findAll() {
        return rankRepository.findAll();
    }

    //랭킹 순위 정렬하는것도 여기에...?

    //알람 1등에게만....이건 api로 ....?

}
