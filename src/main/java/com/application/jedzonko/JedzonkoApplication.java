package com.application.jedzonko;

import com.application.jedzonko.SavingOrdersToPDF.PdfCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class JedzonkoApplication {


    public static void main(String[] args) {
        SpringApplication.run(JedzonkoApplication.class, args);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();

    }


}

