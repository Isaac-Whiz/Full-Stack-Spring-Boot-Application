package com.whizstudios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }

//    @Bean
//    CommandLineRunner runner(GamerService service, GamerJDBCRepository gamerJDBCRepository) {
//        return args -> {
////            gamerJDBCRepository.saveGamer(new Gamer(1,21, "Isaac", "isawwwwwac@gamil.com"));
////            gamerJDBCRepository.saveGamer(new Gamer(2,21, "Uma", "iswaaaaac@gamil.com"));
////            gamerJDBCRepository.saveGamer(new Gamer(3,21, "Ikkkk", "ishgfaac@gamil.com"));
////            gamerJDBCRepository.saveGamer(new Gamer(4,21, "Iddsaac", "isgggaac@gamil.com"));
////            gamerJDBCRepository.saveGamer(new Gamer(5,21, "Iswwaac", "iassaac@gamil.com"));
////            gamerJDBCRepository.saveGamer(new Gamer(6,21, "Isttaac", "isfdaac@gamil.com"));
////            gamerJDBCRepository.saveGamer(new Gamer(7,21, "Isggaac", "isac@gamil.com"));
//        };
//    }
}
