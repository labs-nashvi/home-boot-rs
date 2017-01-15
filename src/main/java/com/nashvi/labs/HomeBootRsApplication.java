package com.nashvi.labs;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class HomeBootRsApplication {

	@RequestMapping("/")
	public String[] home() {
		return new String[] { "You have reached the homepage of home-boot.", "Today is: " + new Date() };
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeBootRsApplication.class, args);
	}
}
