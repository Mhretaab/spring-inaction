package com.spring.inaction.eventhandling.standard;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mberhe on 2/14/19.
 */
@Component
public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent>{
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Context started event recieved");
    }

    public void printMessage(){
        System.out.println("ContextStartEventHandler bean is created ");
    }
}
