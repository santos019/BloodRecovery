package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Rank;
import com.longhair.bloodrecovery.domain.RankRenew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;

@Repository
public interface RankDao extends JpaRepository<Rank, Long> {
    //전체 랭킹!
    public List<>

    //나의 랭킹 하나만!

//    @Query(nativeQuery = true, value = "select p.*, (6371 *
//            acos(cos(radians(?1)) * cos(radians(p.latitude)) *
//            cos(radians(p.longitude) – radians(?2)) + sin(radians(?3)) *
//    sin(radians(p.latitude)))) as distance from Point p having distance <= 3
//    order by distance")
//    public List<Point> findByLatLng(double lat1, double lng, double
//            lat2);

}
