package com.whizstudios.gamer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamerJPAService implements GamerDAO{
    private final GamerJPARepository gamerJPARepository;

    public GamerJPAService(GamerJPARepository gamerJPARepository) {
        this.gamerJPARepository = gamerJPARepository;
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
        gamerJPARepository.save(gamer);
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
        return Optional.empty();
    }

}
