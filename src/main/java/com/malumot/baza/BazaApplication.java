package com.malumot.baza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class BazaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazaApplication.class, args);
	}

//	@Scheduled(fixedRate = 1000L)
//	public void startRate(){
//		System.out.println("New rate"+ new Date());
//	}
//
//	@Scheduled(fixedDelay = 1000L)
//	public void startDelay(){
//		System.out.println("New startDelay"+ new Date());
//	}
//		@Scheduled(cron = "0 30 01 * * *")
//	public void startCron(){
//		System.out.println("New startDelay"+ new Date());
//	}

}
