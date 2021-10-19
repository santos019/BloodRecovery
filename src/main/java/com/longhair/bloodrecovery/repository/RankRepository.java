package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Rank;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RankRepository {

    @PersistenceContext
    private EntityManager em;

    //디비에 저장
    public void save(Rank rank){
        em.persist(rank);
    }

    //나의 랭킹 조회
    public Rank findOne(Long id){
        return em.find(Rank.class, id);
    }

    //전체 랭킹 조회
    public List<Rank> findAll() {
        return em.createQuery("select r from Rank r", Rank.class)
                .getResultList();
    }

}
