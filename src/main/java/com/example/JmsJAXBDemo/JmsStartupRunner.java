package com.example.JmsJAXBDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JmsStartupRunner implements CommandLineRunner {

    private final Producer producer;

    public void run(String... args) {
        producer.sendMessage("MyDestination", "Hello From Yassine!");
    }
}
