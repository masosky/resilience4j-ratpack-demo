package com.test;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class ServiceImpl implements Service {

    @CircuitBreaker(name = "test")
    @Override
    public String greeting(String name) {
        throw new RuntimeException("error");
    }
}
