package com.whizstudios.gamer;

import java.util.List;
import java.util.Optional;

public interface GamerDAO {
    Optional<Gamer> findGamerById(long id);
    List<Gamer> findGamers();
    void saveGamer(Gamer gamer);
    boolean existsGamerWithEmail(String email);
    boolean existsGamerById(long id);
    void deleteGamerById(long id);
    void updateGamer(Gamer update);
    void deleteAllGamers();
    Optional<Gamer> selectGamerById(long id);
}
