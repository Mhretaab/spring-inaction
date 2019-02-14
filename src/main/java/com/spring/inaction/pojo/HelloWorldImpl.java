package com.spring.inaction.pojo;

/**
 * Created by mberhe on 2/13/19.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
