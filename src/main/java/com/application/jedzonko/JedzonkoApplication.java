package com.application.jedzonko;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JedzonkoApplication {
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {


        SpringApplication.run(JedzonkoApplication.class, args);
    }


}

