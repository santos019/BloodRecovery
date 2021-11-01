package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}
