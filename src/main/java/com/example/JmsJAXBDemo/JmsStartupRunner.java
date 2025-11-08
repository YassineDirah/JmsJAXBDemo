package com.example.JmsJAXBDemo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.StringWriter;

@RequiredArgsConstructor
@Component
public class JmsStartupRunner implements CommandLineRunner {

    private final Producer producer;
    private final JAXBContext jaxbContext;

    public void run(String... args) throws JAXBException {
        User user = new User(1L,"Yassine","DIRAH",23);
        StringWriter sw = new StringWriter();
        jaxbContext.createMarshaller().marshal(user, sw);
        String message = sw.toString();
        producer.sendMessage("MyDestination", message);
    }
}
