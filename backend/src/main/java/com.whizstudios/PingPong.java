package com.whizstudios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPong {

<<<<<<< HEAD
    record Ping(String result){};
=======
    record Ping(String ping){};
>>>>>>> b8c25662983a26709289fd5fe3b2a29eade34fec

    @GetMapping("/ping")
    public Ping getPingPong() {
        return new Ping("Pong");
    }
}
