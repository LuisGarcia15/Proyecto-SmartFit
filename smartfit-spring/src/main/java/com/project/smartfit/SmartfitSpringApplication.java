package com.project.smartfit;

import com.project.smartfit.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartfitSpringApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SmartfitSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(this.clientRepository.getAllInformationOneClient(1L).orElseThrow());
	}
}
