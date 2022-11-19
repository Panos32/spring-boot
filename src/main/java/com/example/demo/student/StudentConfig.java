package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student vasia = new Student(

                    "Vasia",
                    "vasia.dim@gmail.com",
                    LocalDate.of(1991, Month.FEBRUARY,13)
            );

            Student panos = new Student(

                    "Panos",
                    "panos.dim@gmail.com",
                    LocalDate.of(1989, Month.FEBRUARY,23)
            );
            repository.saveAll(
                    List.of(vasia, panos)
            );
        };
    }
}
