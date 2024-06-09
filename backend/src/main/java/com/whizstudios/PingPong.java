package com.whizstudios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPong {

    record Ping(String ping){};

    private static int COUNTER = 0;

    @GetMapping("/ping")
    public Ping getPingPong() {
        return new Ping("Pong successful: " + ++COUNTER + " times");
    }
}
