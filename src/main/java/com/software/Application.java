package com.software;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.software.mq.Runner;

@SpringBootApplication
@EnableScheduling
public class Application {
	

	
	    @Bean
	    public CommandLineRunner tutorial() {
	        return new Runner();
	    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
