package com.test.api.controller;

import com.test.api.factory.CalculateFactory;
import com.test.api.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create: 2024-03-17 18:51
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CalculateFactory factory;

    @GetMapping("/calculate")
    public double calculate(@RequestParam double a,
                            @RequestParam double b,
                            @RequestParam String operator) {
        CalculatorService service = factory.getCalculateService(operator);
        return service.calculate(a, b);
    }
}
