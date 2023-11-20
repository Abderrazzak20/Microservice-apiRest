package com.mcService.microService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimoMicroServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(PrimoMicroServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("corretto");
	}
}
