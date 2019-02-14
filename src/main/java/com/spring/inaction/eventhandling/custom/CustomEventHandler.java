package com.spring.inaction.eventhandling.custom;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by mberhe on 2/14/19.
 */
@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.toString());
    }
}
