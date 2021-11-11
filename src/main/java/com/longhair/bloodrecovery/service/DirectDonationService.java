package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.dto.SearchData;
import com.longhair.bloodrecovery.domain.Applicant;
import com.longhair.bloodrecovery.domain.DirectDonation;
import com.longhair.bloodrecovery.dto.*;
import com.longhair.bloodrecovery.repository.ApplicantRepository;
import com.longhair.bloodrecovery.repository.DirectDonationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class DirectDonationService {
    private final static String url = "http://BloodRecovery-LB-1423483073.us-east-2.elb.amazonaws.com:8000/user/";
    private final static int minusPoint = 50;
    private final static int vipLevel = 4;

    @Autowired
    private DirectDonationRepository directDonationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Transactional
    public ApplicantDto saveApplicant(Applicant applicant, Long id){
        Optional<DirectDonation> item = directDonationRepository.findById(id);
        if(item.isPresent()){
            LocalDateTime date = LocalDateTime.now();
            if(item.get().getPeriodTo().isAfter(date)){
                Map map = getUserInfo(applicant.getApplicantIdentify());
                applicant.setApplicantNickname(map.get("nickname").toString());
                applicant.setDirectDonation(item.get());
                applicant.setApplyStatus(false);
                item.get().getApplicants().add(applicant);
                directDonationRepository.save(item.get());
                applicantRepository.save(applicant);
            }
        }
        return new ApplicantDto(applicant);
    }

    @Transactional(readOnly=true)
    public List<ApplicantDto> findApplicantAll(Long directId){
        List<ApplicantDto> list = new ArrayList<>();
        applicantRepository.findByDirectDonation_Id(directId).forEach(e -> list.add(new ApplicantDto(e)));
        return list;
    }

    public void applyApplicant(Applicant applicant, Long id){
        boolean result = true;
        Optional<DirectDonation> directDonation = directDonationRepository.findById(id);
        if(directDonation.isPresent()){
            DirectDonation item = directDonation.get();
            //TODO 혈액증서 인증
            //result = 인증 API 사용.
            if(result){     // 인증 완료
                log.info("인증 성공");
                if(item.getBloodCurrentCount() < item.getBloodMaxCount()){
                    item.setBloodCurrentCount(item.getBloodCurrentCount() + 1);
                    item.getApplicants().add(applicant);
                    applicantRepository.save(applicant);
                    directDonationRepository.save(item);
                }
                else{
                    log.info("이미 꽉찬 신청글입니다.");
                }
            }
            else{           // 인증 실패
                log.info("인증 실패");
            }
        }
    }

    @Transactional(readOnly=true)
    public List<DirectDonationSimpleDto> findDirectDonationAll(SearchData searchData){
        List<DirectDonationSimpleDto> directDonationSimpleDtos = new ArrayList<>();
        List<DirectDonation> directDonations = new ArrayList<>();

        switch (searchData.getSearchMode()){
            case 0:     // 필터링 모드 없는 것.(Status = false)
                directDonations = directDonationRepository.findDirectDonationsByCompleteStatus(false);
                break;
            case 1:     // 혈액형 모드
                directDonations = directDonationRepository.findDirectDonationsByBloodTypeAndCompleteStatus(searchData.getBloodType(), false);
                break;
            case 2:     // 상태 모드 (Status = true)
                directDonations = directDonationRepository.findDirectDonationsByCompleteStatus(true);
                break;
            case 3:     // 혈액형 + 상태 모드
                directDonations = directDonationRepository.findDirectDonationsByBloodTypeAndCompleteStatus(searchData.getBloodType(), true);
                break;
            case 4:     // 장소 모드
                directDonations = directDonationRepository.findDirectDonationsByCompleteStatusAndLocationSidoAndLocationSigungu(false, searchData.getSido(), searchData.getSigungu());
                break;
            case 5:     // 혈액형 + 장소 모드
                directDonations = directDonationRepository.findDirectDonationsByBloodTypeAndCompleteStatusAndLocationSidoAndLocationSigungu(searchData.getBloodType(), false, searchData.getSido(), searchData.getSigungu());
                break;
            case 6:     // 상태 + 장소 모드
                directDonations = directDonationRepository.findDirectDonationsByCompleteStatusAndLocationSidoAndLocationSigungu(true, searchData.getSido(), searchData.getSigungu());
                break;
            case 7:     // 혈액형 + 상태 + 장소 모드
                directDonations = directDonationRepository.findDirectDonationsByBloodTypeAndCompleteStatusAndLocationSidoAndLocationSigungu(searchData.getBloodType(), true, searchData.getSido(), searchData.getSigungu());
                break;
            default:
                break;
        }

        List<DirectDonation> vipItems = new ArrayList<>();
        List<DirectDonation> normalItems = new ArrayList<>();
        directDonations.forEach(e -> {
            if(e.getRequesterLevel() >= vipLevel){
                vipItems.add(e);
            }
            else{
                normalItems.add(e);
            }
        });
        vipItems.forEach(e -> directDonationSimpleDtos.add(new DirectDonationSimpleDto(e)));
        normalItems.forEach(e -> directDonationSimpleDtos.add(new DirectDonationSimpleDto(e)));
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

    private boolean changePoint(String userId, int plusCount, int minusCount, String reason){
        RestTemplate rt = new RestTemplate();
        String location = url + "point";
        Map<String, Object> pointMap = new HashMap<>();
        pointMap.put("userId", userId);
        pointMap.put("plusPoint", plusCount * minusPoint);
        //TODO
        //지정헌혈 헌혈 종류 상관없이 개당 50포인트 차감
        pointMap.put("minusPoint", minusCount * minusPoint);
        pointMap.put("breakdown", reason);
        log.info(location);
        log.info(pointMap.toString());
        ResponseEntity<Map> result = rt.exchange(location, HttpMethod.PUT, new HttpEntity<>(pointMap), Map.class);
        return Boolean.parseBoolean(result.getBody().get("result").toString());
    }

    private Map getUserInfo(String userId){
        RestTemplate rt = new RestTemplate();
        String location = url + "info/" + userId;
        return rt.getForObject(location, Map.class);
    }

    @Transactional
    public DirectDonation saveDirectDonation(DirectDonation directDonation){
        if(!changePoint(directDonation.getRequesterUserId(), 0, directDonation.getBloodMaxCount(), "지정헌혈 요청으로 인한 포인트")){
            return new DirectDonation();
        }

        Map map = getUserInfo(directDonation.getRequesterUserId());
        directDonation.setRequesterNickname(map.get("nickname").toString());
        directDonation.setRequesterLevel(Integer.parseInt(map.get("level").toString()));

        directDonation.setCompleteStatus(false);
        directDonationRepository.save(directDonation);
        return directDonation;
    }

    @Transactional
    public void updateDirectDonationById(DirectDonationUpdateDto directDonationUpdateDto){
        Optional<DirectDonation> e = directDonationRepository.findById(directDonationUpdateDto.getId());
        if(e.isPresent()){
            DirectDonation item = e.get();
            item.setId(directDonationUpdateDto.getId());
            item.setRequesterUserId(directDonationUpdateDto.getRequesterUserId());
            item.setTitle(directDonationUpdateDto.getTitle());
            item.setContents(directDonationUpdateDto.getContents());
            item.setImage(directDonationUpdateDto.getImage());
            item.setPeriodFrom(directDonationUpdateDto.getPeriodFrom());
            item.setPeriodTo(directDonationUpdateDto.getPeriodTo());
            if(item.getCompleteStatus() != directDonationUpdateDto.getCompleteStatus()){
                changeComplete(item);
                item.setCompleteStatus(directDonationUpdateDto.getCompleteStatus());
            }
            directDonationRepository.save(item);
            log.info("업데이트 됨");
        }
    }

    @Transactional
    public void changeComplete(DirectDonation directDonation){
        int num = directDonation.getBloodMaxCount() - directDonation.getBloodCurrentCount();
        changePoint(directDonation.getRequesterUserId(), num, 0, "완료 상태 변경으로 인한 캐쉬백");
    }
}
