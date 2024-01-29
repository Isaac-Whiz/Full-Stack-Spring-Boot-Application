package com.whizstudios.gamer;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamerController {

    private final GamerService gamerService;
    private final GamerJDBCRepository jdbcRepository;

    private final GamerJPAService gamerJPAService;

    public GamerController(GamerService gamerService, GamerJDBCRepository jdbcRepository, GamerJPAService gamerJPAService) {
        this.gamerService = gamerService;
        this.jdbcRepository = jdbcRepository;
        this.gamerJPAService = gamerJPAService;
    }


    @GetMapping(path = "api/v1/gamers/{id}")
    Gamer getGamer(@PathVariable("id") long id) {
        return gamerService.findGamerById(id).orElseThrow(() -> new CustomExceptions("Gamer not found bullshit!"));
    }

    @PostMapping
    void registerGamer(@RequestBody Gamer gamer) {
        gamerJPAService.saveGamer(gamer);
    }

    @GetMapping(path = "api/v1/gamers")
    List<Gamer> getGamers() {
        return gamerService.getGamers();
    }

    @GetMapping(path = "api/v1/gamers/existsByEmail/{email}")
    String gamerExistsByEmail(@PathVariable("email") String email) {
        return jdbcRepository.existsGamerWithEmail(email) ? "Exists by email" : "Does not exist by email";
    }

    @GetMapping(path = "api/v1/gamers/existsById/{id}")
    String gamerExistsById(@PathVariable("id") long id) {
        return jdbcRepository.existsGamerById(id) ? "Exists by id" : "Does not exist by id";
    }

    @DeleteMapping(path = "api/v1/gamers/deleteById/{id}")
    void deleteGamerById(@PathVariable("id") long id) {
        jdbcRepository.deleteGamerById(id);
    }

    @PutMapping(path = "api/v1/gamers/update/{update}")
    void updateGamer(@PathVariable("update") Gamer update) {
        jdbcRepository.updateGamer(update);
    }
}
