package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.RedHouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RedHouseRepository extends JpaRepository<RedHouse, Long> {
    List<RedHouse> findAllByUserId(String userId);
}
