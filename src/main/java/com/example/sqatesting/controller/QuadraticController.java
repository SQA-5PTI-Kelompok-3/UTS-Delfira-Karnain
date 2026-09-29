package com.example.sqatesting.controller;

import com.example.sqatesting.model.QuadraticResult;
import com.example.sqatesting.service.QuadraticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quadratic")
public class QuadraticController {

    private final QuadraticService quadraticService;

    public QuadraticController(QuadraticService quadraticService) {
        this.quadraticService = quadraticService;
    }

    @GetMapping("/solve")
    public QuadraticResult solve(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam double c) {
        return quadraticService.solve(a, b, c);
    }
}
