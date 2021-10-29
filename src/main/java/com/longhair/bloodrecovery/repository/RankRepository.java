package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RankRepository {

    @PersistenceContext
    private EntityManager em;

    //Rank 엔티티 디비에 저장
    public void save(Rank rank){
        em.persist(rank);
    }

    //갱신된 Rank api 디비에 저장
    public void save(RankRenew rankRenew) {
         em.persist(rankRenew);
    }

    //나의 랭킹 조회
    public Rank findOne(Long id){
        return em.find(Rank.class, id);
    }

    //전체 랭킹 조회
    public List<Rank> findAll() {
        return em.createQuery("select r from Rank r order by r.userPoint desc ", Rank.class)
                .getResultList();
    }

//    String jpql = "select user_id,user_nickname,user_profile,user_point, dense_rank() over(order by user_point desc) as rank from ranking r";
//    List<Rank> addbyRank = em.createQuery(jpql, Rank.class).getResultList();

//    private Long userId;
//    private String userNickname;
//    private String userProfile;
//    private int userPoint;

//    String jpql = "select m from Member m where m.age > 18";
//    List<Member> result = em.createQuery(jpql, Member.class)
//            .getResultList();


}
