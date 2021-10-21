package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.dto.ApplicantDto;
import com.longhair.bloodrecovery.dto.DirectDonationDto;
import com.longhair.bloodrecovery.dto.DirectDonationSimpleDto;
import com.longhair.bloodrecovery.dto.PatientDto;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/")
public class DirectDonationController {
    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    DirectDonationRepository directDonationRepository;

    @GetMapping("/directeds")
    public List<DirectDonationSimpleDto> getDirecteds(){
        return null;
    }

    @GetMapping("/directeds/directedItem/{id}")
    public DirectDonationDto getDirectedItem(@PathVariable("id") Long id){
        return null;
    }

    @PutMapping("/directeds/directedItem/{id}")
    public String putDirectedItem(@PathVariable("id") Long id){
        return null;
    }

    @DeleteMapping("/directeds/directedItem/{id}")
    public String deleteDirectedItem(@PathVariable("id") Long id){
        return null;
    }

    @PostMapping("/directeds/directedItem")
    public String postDirectedItem(){
        return null;
    }

    @GetMapping("/directeds/directedItem/{id}/patient")
    public PatientDto getPatient(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/directeds/directedItem/{id}/applicants")
    public List<ApplicantDto> getApplicants(@PathVariable("id") Long id){
        return null;
    }

    @PostMapping("/directeds/directedItem/{id}/applicant")
    public String postApplicant(@PathVariable("id") Long id){
        return null;
    }

    @PostMapping("/directeds/directedItem/{id}/apply")
    public String postApply(@PathVariable("id") Long id){
        return null;
    }

}
