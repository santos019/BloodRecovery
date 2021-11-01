package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
