package com.gametools.arkchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class ArkCheckerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArkCheckerApplication.class, args);
    }
}
