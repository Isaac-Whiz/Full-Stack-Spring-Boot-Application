package com.whizstudios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPong {

    record Ping(String ping){};

    @GetMapping("/ping")
    public Ping getPingPong() {
        return new Ping("Pong message");
    }
}
