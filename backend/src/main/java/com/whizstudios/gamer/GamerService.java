package com.whizstudios.gamer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GamerService {

    private final GamerJDBCRepository jdbcRepository;
    private final GamerDTOMapper gamerDTOMapper;

    public GamerService(GamerJDBCRepository gamerJDBCRepository, GamerDTOMapper gamerDTOMapper) {
        this.jdbcRepository = gamerJDBCRepository;
        this.gamerDTOMapper = gamerDTOMapper;
    }

    Optional<GamerDTO> findGamerById(Long id) {
        return jdbcRepository.findGamerById(id).map(gamerDTOMapper);
    }

    List<GamerDTO> getGamers() {
        return jdbcRepository.findGamers().stream().map(gamerDTOMapper).collect(Collectors.toList());
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
