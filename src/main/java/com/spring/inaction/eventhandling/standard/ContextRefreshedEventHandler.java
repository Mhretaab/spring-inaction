package com.spring.inaction.eventhandling.standard;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mberhe on 2/14/19.
 */
@Component
public class ContextRefreshedEventHandler implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Context refreshed event received");
    }
}
