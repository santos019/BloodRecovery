package com.longhair.bloodrecovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class BloodRecoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodRecoveryApplication.class, args);
	}

}
