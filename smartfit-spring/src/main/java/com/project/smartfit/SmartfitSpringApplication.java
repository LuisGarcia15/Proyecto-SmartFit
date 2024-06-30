package com.project.smartfit;

import com.project.smartfit.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartfitSpringApplication implements CommandLineRunner {

	@Autowired
	public userRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SmartfitSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.repository.findAll());
	}
}
