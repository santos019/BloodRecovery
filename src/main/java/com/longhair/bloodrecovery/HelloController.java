package com.longhair.bloodrecovery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello(){
        return "안녕하세요. 현재 서버시간은 " + new Date() + "입니다.\n" +
                "드디어 CI/CD 구축했어요~~~!!!자바 11버전 웹훅 테스트";
    }
}
