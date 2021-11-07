package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.RedHouse;
import com.longhair.bloodrecovery.repository.RedHouseRepository;
import com.longhair.bloodrecovery.service.RedHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RedHouseController {
    @Autowired
    RedHouseService redHouseService;

    @PostMapping("")
    public ResponseEntity<RedHouse> postRedHouse(@RequestBody RedHouse redHouse){
        return new ResponseEntity<>(redHouseService.reserveRedHouse(redHouse), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<RedHouse>> getRedHouses(@PathVariable("userId")String userId){
        return new ResponseEntity<>(redHouseService.getAllRedHouse(userId), HttpStatus.OK);
    }
}
