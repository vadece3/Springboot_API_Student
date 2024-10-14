package com.vice.springboot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student(
					"Mariam",
					"mariam@gmail.com",
					"date",
					"21"
			);
			
			Student alex = new Student(
					"Alex",
					"alex@gmail.com",
					"date",
					"22"
			);
			
			repository.saveAll(List.of(mariam,alex));
		};
	}

}
