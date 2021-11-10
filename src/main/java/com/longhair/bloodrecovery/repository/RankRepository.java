package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RankRepository {

    @PersistenceContext
    private EntityManager em;

    //Rank 엔티티 디비에 저장
    public void save(Rank rank) {
        em.persist(rank);
    }

    //갱신된 Rank api 디비에 저장
    public void save(RankHistory rankHistory) {
        em.persist(rankHistory);
    }

    //나의 랭킹 조회
    public Rank findOne(String userId) {
        return em.createQuery("select r from Rank r where r.userId = ?1", Rank.class).setParameter(1, userId).getSingleResult();
    }

    //전체 랭킹 조회
    public List<Rank> findAll() {
        return em.createQuery("select r from Rank r order by r.point desc ", Rank.class)
                .getResultList();
    }

    public void updatebyRank() {
        em.createNativeQuery("update rankDB.ranking A, (select ranking_id,dense_rank() over(order by point desc) as user_rank from rankDB.ranking) B set A.user_rank = B.user_rank where A.ranking_id = B.ranking_id;").executeUpdate();
        em.createNativeQuery("commit;").executeUpdate();
    }


}
