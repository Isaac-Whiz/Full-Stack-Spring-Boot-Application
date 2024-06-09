package com.whizstudios.gamer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GamerDTOMapper implements Function<Gamer,  GamerDTO> {
    @Override
    public GamerDTO apply(Gamer gamer) {
        return new GamerDTO(
                gamer.getId(),
                gamer.getName(),
                gamer.getEmail(),
                gamer.getGender(),
                gamer.getAge(),
                gamer.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()),
                gamer.getUsername()
        );
    }
}
