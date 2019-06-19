package com.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

public class Main {

    public static void main(String[] args) {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(5)
                .ringBufferSizeInClosedState(3)
                .build();

        final Injector injector = Guice.createInjector(new CircuitBreakerModule(config));
        final Service service = injector.getInstance(Service.class);

        for (int i = 0; i < 10; i++) {
            try {
                final String hi = service.greeting("hi");
                System.out.println(hi);
            } catch (Throwable e) {
                System.err.println(e.toString());
            }
        }
    }
}
