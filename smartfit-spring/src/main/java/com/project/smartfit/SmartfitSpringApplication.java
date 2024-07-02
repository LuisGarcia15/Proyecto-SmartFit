package com.project.smartfit;

import com.project.smartfit.repositories.TrainingUnitAddressRepository;
import com.project.smartfit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartfitSpringApplication implements CommandLineRunner {

	@Autowired
	public UserRepository repository;

	@Autowired
	public TrainingUnitAddressRepository repository2;

	public static void main(String[] args) {
		SpringApplication.run(SmartfitSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.repository2.findById(1L));
		System.out.println(this.repository.findById(1L));
	}
}
