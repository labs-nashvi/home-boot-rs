package com.nashvi.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HomeBootRsApplication {

	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "You have reached the homepage of home-boot";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HomeBootRsApplication.class, args);
	}
}
