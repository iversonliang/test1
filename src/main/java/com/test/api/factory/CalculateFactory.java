package com.test.api.factory;

import com.test.api.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @create: 2024-03-17 19:00
 */
@Component
public class CalculateFactory {

    private final Map<String, CalculatorService> serviceMap;

    @Autowired
    public CalculateFactory(Map<String, CalculatorService> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public CalculatorService getCalculateService(String operator) {
        if (!serviceMap.containsKey(operator)) {
            throw new IllegalArgumentException("Invalid operator");
        }
        return serviceMap.get(operator);
    }
}
