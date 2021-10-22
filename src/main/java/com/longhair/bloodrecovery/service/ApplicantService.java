package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> findAll(){
        List<Applicant> applicants = new ArrayList<>();
        applicantRepository.findAll().forEach(e -> applicants.add(e));
        return applicants;
    }

    public Applicant save(Applicant applicant, Long id){
        applicant.setId(id);
        applicantRepository.save(applicant);
        return applicant;
    }

    //TODO
    // 지정헌혈 인증기능
    public void apply(Applicant applicant, Long id){

    }
}
