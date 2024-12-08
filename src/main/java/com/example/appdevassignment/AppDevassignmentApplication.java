package com.example.appdevassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.appdevassignment.repository")
@EntityScan(basePackages = "com.example.appdevassignment.entities")
public class AppDevassignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppDevassignmentApplication.class, args);
    }
}
