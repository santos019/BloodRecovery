package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Notice;
import com.longhair.bloodrecovery.dto.NoticeDto;
import com.longhair.bloodrecovery.repository.NoticeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class NoticeService {
    private final static String url = "ec2-18-219-208-124.us-east-2.compute.amazonaws.com:8000/user/";

    @Autowired
    NoticeRespository noticeRespository;

    @Transactional(readOnly = true)
    public List<NoticeDto> getNoticeList(){
        List<NoticeDto> noticeDtos = new ArrayList<>();
        noticeRespository.findAll().forEach(e -> noticeDtos.add(new NoticeDto(e)));
        return noticeDtos;
    }

    @Transactional(readOnly = true)
    public Notice getNotice(Long id){
        return noticeRespository.findById(id).orElseGet(Notice::new);
    }

    @Transactional
    public Notice saveNotice(Notice notice){
        RestTemplate rt = new RestTemplate();
        String location = url + "info/" + notice.getWriterUserId();
        Map map = rt.getForObject(location, Map.class);
        notice.setWriterNickname(map.get("nickname").toString());
        notice.setWriterLevel(Integer.parseInt(map.get("level").toString()));
        notice.setDate(new Date());
        return noticeRespository.save(notice);
    }

    @Transactional
    public Notice updateNotice(Notice notice, Long id){
        Optional<Notice> item = noticeRespository.findById(id);
        if(item.isPresent()){
            notice.setId(id);
            noticeRespository.save(notice);
        }
        return notice;
    }

    @Transactional
    public void deleteNotice(Long id){
        noticeRespository.deleteById(id);
    }
}
