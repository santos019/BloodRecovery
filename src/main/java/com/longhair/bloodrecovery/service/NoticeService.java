package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Notice;
import com.longhair.bloodrecovery.dto.NoticeDto;
import com.longhair.bloodrecovery.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class NoticeService {
    private final static String url = "http://ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/user/";

    @Autowired
    NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<NoticeDto> getNoticeList(){
        List<NoticeDto> noticeDtos = new ArrayList<>();
        noticeRepository.findAll().forEach(e -> noticeDtos.add(new NoticeDto(e)));
        return noticeDtos;
    }

    @Transactional(readOnly = true)
    public Notice getNotice(Long id){
        return noticeRepository.findById(id).orElseGet(Notice::new);
    }

    @Transactional
    public Notice saveNotice(Notice notice){
        RestTemplate rt = new RestTemplate();
        String location = url + "info/" + notice.getWriterUserId();
        Map map = rt.getForObject(location, Map.class);
        notice.setWriterNickname(map.get("nickname").toString());
        notice.setWriterLevel(Integer.parseInt(map.get("level").toString()));
        notice.setDate(LocalDateTime.now());
        return noticeRepository.save(notice);
    }

    @Transactional
    public Notice updateNotice(Notice notice, Long id){
        Notice result = null;
        Optional<Notice> item = noticeRepository.findById(id);
        if(item.isPresent()){
            result = item.get();
            result.setTitle(notice.getTitle());
            result.setContents(notice.getContents());
            result.setImage(notice.getImage());
            result.setImageUrl(notice.getImageUrl());
            result.setDate(LocalDateTime.now());
            noticeRepository.save(result);
        }
        return result;
    }

    @Transactional
    public void deleteNotice(Long id){
        noticeRepository.deleteById(id);
    }

    @Transactional
    public Boolean addProJoinUser(Long id, String userId){
        Optional<Notice> item = noticeRepository.findById(id);
        if(item.isPresent()){
            Notice result = item.get();
            String users = result.getProJoinUsers();
            if(users.contains(userId)){
                return false;
            }
            result.setProJoinUsers(users + "," + userId);

            noticeRepository.save(result);
            return true;
        }
        return false;
    }
}
