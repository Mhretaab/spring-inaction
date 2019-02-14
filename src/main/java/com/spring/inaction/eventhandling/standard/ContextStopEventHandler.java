package com.spring.inaction.eventhandling.standard;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mberhe on 2/14/19.
 */
@Component
public class ContextStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("Context stopped event received");
    }
}
