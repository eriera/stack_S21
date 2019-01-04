package com.siglo.example.service;

import org.springframework.context.ApplicationEvent;

/**
 * This is an optional class used in publishing application events.
 * This can be used to inject events into the Spring Boot audit management endpoint.
 */
public class ProfesorServiceEvent extends ApplicationEvent {

    public ProfesorServiceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My ProfesorServiceEvent Event";
    }
}
