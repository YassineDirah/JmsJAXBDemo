package com.example.JmsJAXBDemo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.StringReader;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final JAXBContext jaxbContext;

    @JmsListener(destination = "MyDestination")
    public void receiveMessage(String message) throws JAXBException {
        StringReader sr = new StringReader(message);
        User user = (User) jaxbContext.createUnmarshaller().unmarshal(sr);
        System.out.println("Received user: " + user);
    }
}
