package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.dto.*;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DirectDonationService {
    @Autowired
    DirectDonationRepository directDonationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Transactional
    public Applicant saveApplicant(Applicant applicant, Long id){
        Optional<DirectDonation> item = directDonationRepository.findById(id);
        if(item.isPresent()){
            applicant.setDirectDonation(item.get());
            item.get().getApplicants().add(applicant);
            directDonationRepository.save(item.get());
            applicantRepository.save(applicant);
        }
        return applicant;
    }

    @Transactional(readOnly=true)
    public List<Applicant> findApplicantAll(Long directId){
        return applicantRepository.findByDirectDonation_Id(directId);
    }

    //TODO
    // 지정헌혈 인증기능
    public void applyApplicant(Applicant applicant, Long id){

    }

    @Transactional(readOnly=true)
    public List<DirectDonationSimpleDto> findDirectDonationAll(){
        List<DirectDonationSimpleDto> directDonationSimpleDtos = new ArrayList<>();
        directDonationRepository.findAll().forEach(e -> directDonationSimpleDtos.add(new DirectDonationSimpleDto(e)));
        return directDonationSimpleDtos;
    }

    @Transactional(readOnly=true)
    public DirectDonationDto findDirectDonationById(Long id){
        return new DirectDonationDto(directDonationRepository.findById(id).orElseGet(DirectDonation::new));
    }

    @Transactional(readOnly=true)
    public PatientDto findPatientById(Long id){
        return new PatientDto(directDonationRepository.findById(id).orElseGet(DirectDonation::new));
    }

    @Transactional
    public void deleteDirectDonationById(Long id){
        Optional<DirectDonation> item = directDonationRepository.findById(id);
        List<Long> idList = new ArrayList<>();
        if(item.isPresent()){
            item.get().getApplicants().forEach(e -> idList.add(e.getId()));
            applicantRepository.deleteAllById(idList);
        }
        directDonationRepository.deleteById(id);
    }

    @Transactional
    public DirectDonation saveDirectDonation(DirectDonation directDonation){
        //Todo
        // 요청자 정보 가져오기

        directDonationRepository.save(directDonation);
        return directDonation;
    }

    @Transactional
    public void updateDirectDonationById(Long id, DirectDonationUpdateDto directDonationUpdateDto){
        Optional<DirectDonation> e = directDonationRepository.findById(id);

        if(e.isPresent()){
            e.get().setId(directDonationUpdateDto.getId());
            e.get().setRequesterId(directDonationUpdateDto.getRequesterId());
            e.get().setTitle(directDonationUpdateDto.getTitle());
            e.get().setContents(directDonationUpdateDto.getContents());
            e.get().setImage(directDonationUpdateDto.getImage());
            e.get().setDate(directDonationUpdateDto.getDate());
            e.get().setPeriodFrom(directDonationUpdateDto.getPeriodFrom());
            e.get().setPeriodTo(directDonationUpdateDto.getPeriodTo());
            e.get().setCompleteStatus(directDonationUpdateDto.getCompleteStatus());
            directDonationRepository.save(e.get());
        }
    }
}
