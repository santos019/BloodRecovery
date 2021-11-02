package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
    public List<Point> findAllByUserId(String userId);
}
