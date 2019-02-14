package com.spring.inaction.eventhandling.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by mberhe on 2/14/19.
 */
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(){
        CustomEvent ce = new CustomEvent(this);
        publisher.publishEvent(ce);
    }
}
