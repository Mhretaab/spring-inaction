package com.spring.inaction.eventhandling.custom;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mberhe on 2/14/19.
 */

public class CustomEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "My Custom Event";
    }
}
