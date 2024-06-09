package com.whizstudios.gamer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

class GamerJPAServiceTest {

    private GamerJPAService underTest;

    @Mock
    private GamerJPARepository gamerJPARepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new GamerJPAService(gamerJPARepository, passwordEncoder);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void itShouldFindGamerById() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldFindGamers() {
        //When
        underTest.findGamers();
        //Then
        Mockito.verify(gamerJPARepository).findAll();
    }

    @Test
    void itShouldSaveGamer() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldExistsGamerById() {
        //Given
        long id = 67;
        //When
        underTest.findGamerById(id);
        //Then
        Mockito.verify(gamerJPARepository).findById(id);
    }

    @Test
    void itShouldDeleteGamerById() {
        //Given
        //When
        //Then
    }
}