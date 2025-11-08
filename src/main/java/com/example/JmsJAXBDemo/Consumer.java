package com.example.JmsJAXBDemo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "MyDestination")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
