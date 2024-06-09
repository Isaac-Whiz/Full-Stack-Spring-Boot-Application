package com.whizstudios.gamer;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamerJPAService implements GamerDAO{
    private final GamerJPARepository gamerJPARepository;
    private final PasswordEncoder passwordEncoder;

    public GamerJPAService(GamerJPARepository gamerJPARepository, PasswordEncoder passwordEncoder) {
        this.gamerJPARepository = gamerJPARepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Gamer> findGamerById(long id) {
        return gamerJPARepository.findById(id);
    }

    @Override
    public List<Gamer> findGamers() {
        return gamerJPARepository.findAll();
    }

    @Override
    public void saveGamer(Gamer gamer) {
        var encodedPassword  = passwordEncoder.encode(gamer.getPassword());
        var encodedGamer = new Gamer(gamer.getId(),
                gamer.getAge(),
                gamer.getName(),
                gamer.getEmail(),
                encodedPassword,
                gamer.getGender());
        gamerJPARepository.save(encodedGamer);
    }

    @Override
    public boolean existsGamerWithEmail(String email) {
        return false;
    }

    @Override
    public boolean existsGamerById(long id) {
        return gamerJPARepository.existsById(id);
    }

    @Override
    public void deleteGamerById(long id) {
        gamerJPARepository.deleteById(id);
    }

    @Override
    public void updateGamer(Gamer update) {
        gamerJPARepository.save(update);
    }

    @Override
    public void deleteAllGamers() {
    }

    @Override
    public Optional<Gamer> selectGamerById(long id) {
        return gamerJPARepository.findById(id);
    }

    @Override
    public Optional<Gamer> selectGamerByEmail(String email) {
        return gamerJPARepository.findByEmail(email);
    }

}
