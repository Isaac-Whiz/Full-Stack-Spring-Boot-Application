package com.whizstudios.gamer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class GamerJPAServiceTest {

    private GamerJPAService underTest;

    @Mock
    private GamerRepository gamerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new GamerJPAService(gamerRepository);
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
        Mockito.verify(gamerRepository).findAll();
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
        Mockito.verify(gamerRepository).findById(id);
    }

    @Test
    void itShouldDeleteGamerById() {
        //Given
        //When
        //Then
    }
}