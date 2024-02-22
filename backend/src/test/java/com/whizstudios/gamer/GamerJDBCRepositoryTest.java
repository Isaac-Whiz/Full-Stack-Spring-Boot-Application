package com.whizstudios.gamer;

import com.example.full_stack.AbstractUnitTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class GamerJDBCRepositoryTest extends AbstractUnitTests {

    private GamerJDBCRepository gamerJDBCRepository;
    private final GamerRowMapper gamerRowMapper = new GamerRowMapper();

    @BeforeEach
    void setUp() {
        gamerJDBCRepository = new GamerJDBCRepository(
                getJdbcTemplate(),
                gamerRowMapper);
    }

    @Test
    void itShouldFindGamerById() {
        Gamer gamer = new Gamer(9,20, "Jim", "eeeeeee" + UUID.randomUUID(), Gender.valueOf(Gender.FEMALE.toString()));
        gamerJDBCRepository.saveGamer(gamer);
        //Given
        var gamerById = gamerJDBCRepository.findGamerById(9);
        //When
        assertThat(gamerById).isNotEmpty();
        //Then
    }

    @Test
    void itShouldFindGamers() {
        //Given
        Gamer gamer = new Gamer(9,20, "Jim", "eeeeeee" + UUID.randomUUID(), Gender.valueOf(Gender.MALE.toString()));
        gamerJDBCRepository.saveGamer(gamer);
        //When
        List<Gamer> gamers = gamerJDBCRepository.findGamers();
        gamers.forEach(System.out::println);
        //Then
        assertThat(gamers).isNotEmpty();
    }

    @Test
    void itShouldSaveGamer() {
        //Given
        Gamer gamer =  new Gamer(10, 20, "Jux", "jux@gamil.com", Gender.valueOf(Gender.FEMALE.toString()));
        //When
        gamerJDBCRepository.saveGamer(gamer);

        //Then
//        gamerJDBCRepository.findGamerById(10).isPresent();
        assertThat(gamerJDBCRepository.findGamerById(10)).isNotEmpty();
    }

    @Test
    void itShouldExistsGamerWithEmail() {
        //Given
        Gamer gamer =  new Gamer(10, 20, "Jux", "jux@gmail.com", Gender.valueOf(Gender.MALE.toString()));
        //When
        gamerJDBCRepository.saveGamer(gamer);
        //Then
        assertThat(gamerJDBCRepository.existsGamerWithEmail("jux@gmail.com")).isTrue();
    }

    @Test
    void itShouldExistsGamerById() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldDeleteGamerById() {
        //Given
//        Gamer gamer = new Gamer(1, 23, "Siriimu", "siriimu@gmail.com");
        Gamer gamer = new Gamer(1, 23, "Siriimu", "siriimu@gmail.com", Gender.valueOf(Gender.MALE.toString()));
        gamerJDBCRepository.saveGamer(gamer);
        //When
        gamerJDBCRepository.deleteGamerById(1);
        //Then
        assertThat(gamerJDBCRepository.findGamerById(1)).isEmpty();
    }

    @Test
    void itShouldUpdateGamer() {
        //Given
        Gamer gamer = new Gamer(1, 23, "Siriimu", "siriimu@gmail.com", Gender.valueOf(Gender.MALE.toString()));
        gamerJDBCRepository.saveGamer(gamer);
        //When
        gamerJDBCRepository.updateGamer(new Gamer(1, 23,
                "Mukenenya", "mukenenya@gmail.com", Gender.valueOf(Gender.MALE.toString())));
        //Then
        assertThat(gamerJDBCRepository.findGamerById(1).get().getName().equals("Mukenenya") &&
                gamerJDBCRepository.findGamerById(1).get().getEmail().equals("mukenenya@gmail.com")).isTrue();
    }
}