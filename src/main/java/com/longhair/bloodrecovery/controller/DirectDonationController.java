package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.dto.*;
import com.longhair.bloodrecovery.service.DirectDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DirectDonationController {
    @Autowired
    DirectDonationService directDonationService;

    // Jenkins Test

    @GetMapping("/directeds")
    public ResponseEntity<List<DirectDonationSimpleDto>> getDirecteds(){
        List<DirectDonationSimpleDto> directDonationSimpleDtos = directDonationService.findDirectDonationAll();
        return new ResponseEntity<>(directDonationSimpleDtos, HttpStatus.OK);
    }

    @GetMapping("/directeds/directedItem/{id}")
    public ResponseEntity<DirectDonationDto> getDirectedItem(@PathVariable("id") Long id){
        return new ResponseEntity<>(directDonationService.findDirectDonationById(id), HttpStatus.OK);
    }

    @PutMapping("/directeds/directedItem/{id}")
    public void putDirectedItem(@RequestBody DirectDonationUpdateDto directDonationUpdateDto, @PathVariable("id") Long id){
        directDonationService.updateDirectDonationById(id, directDonationUpdateDto);
    }

    @DeleteMapping("/directeds/directedItem/{id}")
    public void deleteDirectedItem(@PathVariable("id") Long id){
        directDonationService.deleteDirectDonationById(id);
    }

    @PostMapping("/directeds/directedItem")
    public ResponseEntity<DirectDonation> postDirectedItem(@RequestBody DirectDonation directDonation){
        System.out.println("==============Receive DirectDonation============");
        System.out.println(directDonation);
        return new ResponseEntity<>(directDonationService.saveDirectDonation(directDonation), HttpStatus.OK);
    }

    @GetMapping("/directeds/directedItem/{id}/patient")
    public ResponseEntity<PatientDto> getPatient(@PathVariable("id") Long id){
        return new ResponseEntity<>(directDonationService.findPatientById(id), HttpStatus.OK);
    }

    @GetMapping("/directeds/directedItem/{id}/applicants")
    public ResponseEntity<List<Applicant>> getApplicants(@PathVariable("id") Long id){
        List<Applicant> applicants = directDonationService.findApplicantAll(id);

        return new ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @PostMapping("/directeds/directedItem/{id}/applicant")
    public ResponseEntity<Applicant> postApplicant(@RequestBody Applicant applicant, @PathVariable("id") Long id){
        return new ResponseEntity<>(directDonationService.saveApplicant(applicant, id), HttpStatus.OK);
    }

    @PostMapping("/directeds/directedItem/{id}/apply")
    public String postApply(@PathVariable("id") Long id){
        directDonationService.applyApplicant(new Applicant(), id);
        return null;
    }

}
