package com.Student.demo.config;

import com.Student.demo.model.User;
import com.Student.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Check if 'admin' already exists so we don't create duplicates
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println(">>> Security: Default user created (admin/admin123)");
            }
        };
    }
}