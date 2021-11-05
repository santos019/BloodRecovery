package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.Notice;
import com.longhair.bloodrecovery.dto.NoticeDto;
import com.longhair.bloodrecovery.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("")
    public ResponseEntity<List<NoticeDto>> getNotices(){
        return new ResponseEntity<>(noticeService.getNoticeList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNotice(@PathVariable("id")Long id){
        return new ResponseEntity<>(noticeService.getNotice(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Notice> postNotice(@RequestBody Notice notice){
        return new ResponseEntity<>(noticeService.saveNotice(notice), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> putNotice(@RequestBody Notice notice, @PathVariable("id")Long id){
        return new ResponseEntity<>(noticeService.updateNotice(notice, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable("id")Long id){
        noticeService.deleteNotice(id);
    }
}
