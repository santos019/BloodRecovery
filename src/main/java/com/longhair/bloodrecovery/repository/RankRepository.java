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

    //Rank 엔티티 디비에 저장
    public void save(Rank rank){
        em.persist(rank);
    }

    //갱신된 Rank api 디비에 저장
    public void save()
        //엔티티가 없는데.. 어케 저장하죠..?ㅠ


    //나의 랭킹 조회
    public Rank findOne(Long id){
        return em.find(Rank.class, id);
    }

    //전체 랭킹 조회 (백업되어 있는 랭킹 데이터들... 역순으로 가져오던지..?)
    public List<Rank> findAll() {
        return em.createQuery("select r from Rank r", Rank.class)
                .getResultList();
    }

}
