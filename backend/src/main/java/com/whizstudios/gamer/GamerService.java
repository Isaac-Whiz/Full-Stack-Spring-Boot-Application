package com.whizstudios.gamer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GamerService {

    private final GamerJDBCRepository jdbcRepository;

    public GamerService(GamerJDBCRepository gamerJDBCRepository) {
        this.jdbcRepository = gamerJDBCRepository;
    }

    Optional<Gamer> findGamerById(Long id) {
        return jdbcRepository.findGamerById(id);
    }

    List<Gamer> getGamers() {
        return jdbcRepository.findGamers();
    }


    void updateGamer(long id, GamerUpdateRequest update) {
       Gamer gamer = jdbcRepository.selectGamerById(id).orElseThrow(() -> new NoSuchElementException(
               "Gamer with id [%s] not found".formatted(id)
       ));


       if (update.name() != null && !update.name().equals(gamer.getName())) {
           gamer.setName(update.name());
       }

       if (!(update.age() == gamer.getAge())) {
           gamer.setAge(update.age());
       }

       if (update.email() != null && !update.email().equals(gamer.getEmail())) {
           gamer.setEmail(update.email());
       }

       jdbcRepository.updateGamer(gamer);

    }

}
