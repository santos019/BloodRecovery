package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.dto.ApplicantDto;
import com.longhair.bloodrecovery.dto.DirectDonationDto;
import com.longhair.bloodrecovery.dto.DirectDonationSimpleDto;
import com.longhair.bloodrecovery.dto.PatientDto;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import com.longhair.bloodrecovery.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DirectDonationController {
    @Autowired
    ApplicantService applicantService;

    @Autowired
    DirectDonationRepository directDonationRepository;

    @GetMapping("/directeds")
    public ResponseEntity<List<DirectDonationSimpleDto>> getDirecteds(){
        return null;
    }

    @GetMapping("/directeds/directedItem/{id}")
    public ResponseEntity<DirectDonationDto> getDirectedItem(@PathVariable("id") Long id){
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
    public ResponseEntity<PatientDto> getPatient(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/directeds/directedItem/{id}/applicants")
    public ResponseEntity<List<Applicant>> getApplicants(@PathVariable("id") Long id){
        List<Applicant> applicants = applicantService.findAll();

        return new ResponseEntity<List<Applicant>>(applicants, HttpStatus.OK);
    }

    @PostMapping("/directeds/directedItem/{id}/applicant")
    public ResponseEntity<Applicant> postApplicant(Applicant applicant, @PathVariable("id") Long id){
        return new ResponseEntity<Applicant>(applicantService.save(applicant, id), HttpStatus.OK);
    }

    @PostMapping("/directeds/directedItem/{id}/apply")
    public String postApply(@PathVariable("id") Long id){
        return null;
    }

}
