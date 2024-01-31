package com.whizstudios.gamer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamerJPAService implements GamerDAO{
    private final GamerRepository gamerRepository;

    public GamerJPAService(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    @Override
    public Optional<Gamer> findGamerById(long id) {
        return gamerRepository.findById(id);
    }

    @Override
    public List<Gamer> findGamers() {
        return gamerRepository.findAll();
    }

    @Override
    public void saveGamer(Gamer gamer) {
        gamerRepository.save(gamer);
    }

    @Override
    public boolean existsGamerWithEmail(String email) {
        return false;
    }

    @Override
    public boolean existsGamerById(long id) {
        return gamerRepository.existsById(id);
    }

    @Override
    public void deleteGamerById(long id) {
        gamerRepository.deleteById(id);
    }

    @Override
    public void updateGamer(Gamer update) {
    }
}
