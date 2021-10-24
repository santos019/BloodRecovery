package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.dto.*;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DirectDonationService {
    @Autowired
    DirectDonationRepository directDonationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> findApplicantAll(Long id){
        Optional<DirectDonation> item = directDonationRepository.findById(id);
        List<Applicant> applicants = null;
        if(item.isPresent()){
            applicants = item.get().getApplicants();
        }
        return applicants;
    }

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

    //TODO
    // 지정헌혈 인증기능
    public void applyApplicant(Applicant applicant, Long id){

    }

    public List<DirectDonationSimpleDto> findDirectDonationAll(){
        List<DirectDonationSimpleDto> directDonationSimpleDtos = new ArrayList<>();
        directDonationRepository.findAll().forEach(e -> directDonationSimpleDtos.add(new DirectDonationSimpleDto(e)));
        return directDonationSimpleDtos;
    }

    public Optional<DirectDonationDto> findDirectDonationById(Long id){
        DirectDonation result = directDonationRepository.findById(id).orElseGet(DirectDonation::new);
        return Optional.of(new DirectDonationDto(result));
    }

    public Optional<PatientDto> findPatientById(Long id){
        DirectDonation result = directDonationRepository.findById(id).orElseGet(DirectDonation::new);
        return Optional.of(new PatientDto(result));
    }

    public void deleteDirectDonationById(Long id){
        Optional<DirectDonation> item = directDonationRepository.findById(id);
        List<Long> idList = new ArrayList<>();
        if(item.isPresent()){
            item.get().getApplicants().forEach(e -> idList.add(e.getId()));
            applicantRepository.deleteAllById(idList);
        }
        directDonationRepository.deleteById(id);
    }

    public DirectDonation saveDirectDonation(DirectDonation directDonation){
        directDonationRepository.save(directDonation);
        return directDonation;
//        DirectDonation directDonation = new DirectDonation(
//                directDonationFullDto.getId(),
//                directDonationFullDto.getRequesterId(),
//                directDonationFullDto.getRequesterNickname(),
//                directDonationFullDto.getRequesterLevel(),
//                directDonationFullDto.getTitle(),
//                directDonationFullDto.getContents(),
//                directDonationFullDto.getImage(),
//                directDonationFullDto.getDate(),
//                directDonationFullDto.getLocationSido(),
//                directDonationFullDto.getLocationSigungu(),
//                directDonationFullDto.getPeriodFrom(),
//                directDonationFullDto.getPeriodTo(),
//                directDonationFullDto.getBloodType(),
//                directDonationFullDto.getBloodMaxCount(),
//                directDonationFullDto.getBloodCurrentCount(),
//                directDonationFullDto.getCompleteStatus(),
//                directDonationFullDto.getPatientName(),
//                directDonationFullDto.getHospitalName(),
//                directDonationFullDto.getRoomNumber(),
//                directDonationFullDto.getApplicants().stream()
//                        .map(m -> new Applicant(m.getId(), m.getApplicantNickname(), m.getApplyStatus(), m.getDirectDonationId()))
//                        .collect(Collectors.toList())
//        );
    }

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
