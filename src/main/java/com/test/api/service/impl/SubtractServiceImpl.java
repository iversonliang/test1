package com.test.api.service.impl;

import com.test.api.service.CalculatorService;
import org.springframework.stereotype.Component;

/**
 * @create: 2024-03-17 18:59
 */
@Component("sub")
public class SubtractServiceImpl implements CalculatorService {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
