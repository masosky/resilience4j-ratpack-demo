package com.test;

import com.google.inject.AbstractModule;
import io.github.resilience4j.ratpack.Resilience4jConfig;
import io.github.resilience4j.ratpack.Resilience4jModule;

public class CircuitBreakerModule extends AbstractModule {

    private final Resilience4jConfig config;

    public CircuitBreakerModule(Resilience4jConfig config) {
        this.config = config;
    }

    @Override
    protected void configure() {
        //bind(CircuitBreakerRegistry.class).toInstance(CircuitBreakerRegistry.of(config));
        //bind(ServerConfig.class).to(DefaultServerConfig.class);
        Resilience4jModule module = new Resilience4jModule();
        module.setConfig(config);
        install(module);
//        CircuitBreakerMethodInterceptor interceptor = new CircuitBreakerMethodInterceptor();
//        requestInjection(interceptor);
//        bindInterceptor(Matchers.any(), Matchers.annotatedWith(CircuitBreaker.class), interceptor);
//        bind(Service.class).to(ServiceImpl.class);

    }
}
