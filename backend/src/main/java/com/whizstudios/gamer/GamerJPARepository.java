package com.whizstudios.gamer;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GamerJPARepository extends JpaRepository<Gamer, Long> {

    @Nonnull
    Optional<Gamer> findById(Long id);
    void deleteById(Long id);

}
