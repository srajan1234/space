package com.space.satellites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SatellitesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatellitesApplication.class, args);
	}

}
