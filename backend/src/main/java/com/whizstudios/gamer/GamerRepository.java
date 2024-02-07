package com.whizstudios.gamer;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GamerRepository extends JpaRepository<Gamer, Long> {

    @Nonnull
    Optional<Gamer> findById(Long id);
    List<Gamer> findTopBy();
}
