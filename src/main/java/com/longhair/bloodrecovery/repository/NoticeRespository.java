package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRespository extends JpaRepository<Notice, Long> {
}
