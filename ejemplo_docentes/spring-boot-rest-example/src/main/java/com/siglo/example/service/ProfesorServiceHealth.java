package com.siglo.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * This is an optional class used to inject application specific health check
 * into the Spring Boot health management endpoint.
 */
public class ProfesorServiceHealth implements HealthIndicator {

    @Autowired
    private ServiceProperties configuration;

    // extend this to create an application-specific health check according to http://goo.gl/vt8I7O
    @Override
    public Health health() {
        return Health.up().withDetail("details", "{ 'internals' : 'getting close to limit', 'profile' : '" + this.configuration.getName() + "' }").status("itsok!").build();
    }
}