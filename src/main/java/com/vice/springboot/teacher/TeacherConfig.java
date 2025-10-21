package com.vice.springboot.teacher;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner tcommandLineRunner(TeacherRepository repository) {
        return args -> {
            Teacher mariam = new Teacher(
                    "Mariam",
                    "mariam@gmail.com",
                    "date",
                    "21"
            );

            Teacher alex = new Teacher(
                    "Alex",
                    "alex@gmail.com",
                    "date",
                    "22"
            );

            repository.saveAll(List.of(mariam,alex));
        };
    }

}

