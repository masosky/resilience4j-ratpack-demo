package com.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.resilience4j.ratpack.Resilience4jConfig;

public class Main {

    public static void main(String[] args) {
        Resilience4jConfig config = new Resilience4jConfig();
        config.metrics(true);
        config.prometheus(true);
        config.circuitBreaker("test", c ->
                c.setFailureRateThreshold(5)
                        .setRingBufferSizeInClosedState(3));


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
