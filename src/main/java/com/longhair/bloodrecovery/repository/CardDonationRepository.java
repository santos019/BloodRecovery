package com.longhair.bloodrecovery.repository;

import com.longhair.bloodrecovery.dto.CardRequestSimpleDto;
import com.longhair.bloodrecovery.entity.CardRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardDonationRepository extends JpaRepository<CardRequest, Long> {
    List<CardRequest> findCardRequestByCompleteStatus(boolean completeStatus);
    List<CardRequest> findByUserId(String userId);
}

