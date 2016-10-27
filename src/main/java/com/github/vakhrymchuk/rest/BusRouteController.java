package com.github.vakhrymchuk.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/direct")
public class BusRouteController {

    @GetMapping
    public String direct() {
        return "Greetings from Spring Boot!";
    }

}
