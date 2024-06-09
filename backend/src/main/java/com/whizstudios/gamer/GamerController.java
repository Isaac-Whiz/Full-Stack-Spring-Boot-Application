package com.whizstudios.gamer;


import com.whizstudios.exception.ResourceNonFoundException;
import com.whizstudios.jwt.JWTUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamerController {

    private final GamerService gamerService;
    private final GamerJDBCRepository jdbcRepository;
    private final GamerJPAService gamerJPAService;
    private final JWTUtil jwtUtil;

    public GamerController(GamerService gamerService, GamerJDBCRepository jdbcRepository, GamerJPAService gamerJPAService, JWTUtil jwtUtil) {
        this.gamerService = gamerService;
        this.jdbcRepository = jdbcRepository;
        this.gamerJPAService = gamerJPAService;
        this.jwtUtil = jwtUtil;
    }


    @GetMapping(path = "api/v1/gamers/{id}")
    GamerDTO getGamer(@PathVariable("id") long id) {
        return gamerService.findGamerById(id).orElseThrow(() -> new ResourceNonFoundException("Gamer not found."));
    }

    @PostMapping("api/v1/gamer")
    ResponseEntity<?> registerGamer(@RequestBody Gamer gamer) {
        gamerJPAService.saveGamer(gamer);
        String jwtToken = jwtUtil.issueToken(gamer.getEmail(), "ROLE_USER");
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwtToken)
                .build();
    }

    @GetMapping(path = "api/v1/gamers")
    List<GamerDTO> getGamers() {
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

    @PutMapping(path = "api/v1/gamers/update/{id}")
    void updateGamer(@PathVariable("id") long id, @RequestBody GamerUpdateRequest update) {
        gamerService.updateGamer(id, update);
    }

}
