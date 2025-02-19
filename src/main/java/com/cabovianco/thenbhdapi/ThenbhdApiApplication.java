package com.cabovianco.thenbhdapi;

import com.cabovianco.thenbhdapi.dto.UserDto;
import com.cabovianco.thenbhdapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThenbhdApiApplication implements CommandLineRunner {

    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    private final UserService userService;

    @Autowired
    public ThenbhdApiApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ThenbhdApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        userService.deleteAllUsers();

        UserDto admin = UserDto.builder()
                .username(adminUsername)
                .password(adminPassword)
                .build();

        userService.registerUser(admin);
    }

}
