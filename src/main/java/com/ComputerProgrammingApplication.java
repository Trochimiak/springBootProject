package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan(basePackages = {"com", "com.app.controller", "com.app.dao", "com.app.service", "com.app.model"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Controller
public class ComputerProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputerProgrammingApplication.class, args);
    }

    @RequestMapping("/")
    public String start() {
        return "startPage";
    }

}
