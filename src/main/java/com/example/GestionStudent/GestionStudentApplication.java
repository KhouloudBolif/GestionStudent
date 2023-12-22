package com.example.GestionStudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.GestionStudent.Entity")
@EnableJpaRepositories("com.example.GestionStudent.Repository")
@ComponentScan("com.example.GestionStudent.Services")
@ComponentScan("com.example.GestionStudent.Controller")
@SpringBootApplication
public class GestionStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStudentApplication.class, args);
	}

}
