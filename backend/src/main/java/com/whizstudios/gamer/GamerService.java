package com.whizstudios.gamer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamerService {

    private final GamerRepository gamerRepository;
    private final GamerJDBCRepository jdbcRepository;

    public GamerService(GamerRepository gamerRepository, GamerJDBCRepository gamerJDBCRepository) {
        this.gamerRepository = gamerRepository;
        this.jdbcRepository = gamerJDBCRepository;
    }

    Optional<Gamer> findGamerById(Long id) {
        return jdbcRepository.findGamerById(id);
    }

    List<Gamer> getGamers() {
        return jdbcRepository.findGamers();
    }
}
