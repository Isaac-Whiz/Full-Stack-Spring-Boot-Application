package com.whizstudios.gamer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameJPARepository extends JpaRepository<Gamer, Long> {
    boolean existsGamerByEmail(String email);
    boolean existsById(long id);
}
