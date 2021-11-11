package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.Notice;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeDto {
    private Long id;
    private String writerNickname;
    private int writerLevel;
    private String title;
    private LocalDateTime date;

    public NoticeDto(Notice notice){
        this.id = notice.getId();
        this.writerNickname = notice.getWriterNickname();
        this.writerLevel = notice.getWriterLevel();
        this.title = notice.getTitle();
        this.date = notice.getDate();
    }
}
