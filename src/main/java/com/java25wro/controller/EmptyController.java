package com.java25wro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class EmptyController {

    @GetMapping(value = "/")
    public String helloWorld() {
        return "Hello World";
    }
}
