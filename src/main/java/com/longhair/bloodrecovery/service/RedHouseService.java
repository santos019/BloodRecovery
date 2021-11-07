package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.RedHouse;
import com.longhair.bloodrecovery.repository.RedHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RedHouseService {
    @Autowired
    RedHouseRepository redHouseRepository;

    @Transactional
    public RedHouse reserveRedHouse(RedHouse redHouse){
        redHouse.setDate(new Date());
        return redHouseRepository.save(redHouse);
    }

    @Transactional(readOnly = true)
    public List<RedHouse> getAllRedHouse(String userId){
        return redHouseRepository.findAllByUserId(userId);
    }
}
