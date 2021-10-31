package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankDao extends JpaRepository<Rank, Long> {

//    @Query(nativeQuery = true, value = "select ranking_id,user_id,user_nickname,user_profile,user_point,dense_rank() over(order by user_point desc) as user_rank from ranking")
//    public List<Rank> addbyRank();

//    void addRank();

//    private Long userId;
//    private String userNickname;
//    private String userProfile;
//    private int userPoint;

//    List<Movie> searchByTitleLike(@Param("title") String title);




//
//    @Query(nativeQuery = true, value = "select p.*, (6371 *
//            acos(cos(radians(?1)) * cos(radians(p.latitude)) *
//            cos(radians(p.longitude) – radians(?2)) + sin(radians(?3)) *
//    sin(radians(p.latitude)))) as distance from Point p having distance <= 3
//    order by distance")
//    public List<Point> findByLatLng(double lat1, double lng, double
//            lat2);

}