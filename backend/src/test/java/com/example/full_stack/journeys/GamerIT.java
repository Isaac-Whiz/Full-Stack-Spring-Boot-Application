package com.example.full_stack.journeys;

import com.whizstudios.gamer.Gamer;
import com.whizstudios.gamer.GamerDTO;
import com.whizstudios.gamer.Gender;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GamerIT {
    @Autowired
    private WebTestClient webTestClient;

    private static final Random RANDOM  = new Random();
    private static final String GAMER_PATH = "/api/v1/gamers";

    @Test
    void canRegisterGamer() {
        Faker faker = new Faker();
        Name fakerName = faker.name();

        String name = fakerName.fullName();
        String email = fakerName.lastName() + "-" + UUID.randomUUID() + "@whiz.com";
        int age = RANDOM.nextInt(1, 100);

        Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;

        Gamer gamer = new Gamer(age, name, email, "password", gender.toString());

        String jwtToken = webTestClient.post()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamer), Gamer.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Void.class)
                .getResponseHeaders()
                .get(AUTHORIZATION)
                .get(0);

        List<GamerDTO> allGamers = webTestClient.get()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(new ParameterizedTypeReference<GamerDTO>() {
                })
                .returnResult()
                .getResponseBody();

        Long id = allGamers.stream().filter(gamerItem -> gamerItem.email().equals(email)).map(GamerDTO::id).findFirst().orElseThrow();
        GamerDTO expectedGamer = new GamerDTO(
                id,
                name,
                email,
                gender.toString(),
                age,
                List.of("ROLE_USER"),
                email
        );

        assertThat(allGamers).contains(expectedGamer);

        webTestClient.get()
                .uri(GAMER_PATH + "/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<GamerDTO>() {
                })
                .isEqualTo(expectedGamer);
    }

    @Test
    void canDeleteCustomer(){
        var faker = new Faker();
        Name fName = faker.name();

        String name = fName.fullName();
        String email = fName.lastName() + "-" + UUID.randomUUID() + "@whizhgames.com";
        int age = RANDOM.nextInt(1, 100);

        Gender gender = Gender.valueOf(age % 2 == 0 ? "MALE" : "FEMALE");

        var gamer1 = new Gamer(age, name, email, "password", gender.toString());
        var gamer2 = new Gamer(age, name, email + ".ug", "password", gender.toString());

        webTestClient.post()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamer1), Gamer.class)
                .exchange()
                .expectStatus()
                .isOk();

        var jwtToken = webTestClient.post()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamer2), Gamer.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Void.class)
                .getResponseHeaders()
                .get(AUTHORIZATION)
                .get(0);

        List<GamerDTO> allGamers = webTestClient.get()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(new ParameterizedTypeReference<GamerDTO>() {
                })
                .returnResult()
                .getResponseBody();

        var id = allGamers.stream()
                .filter(gamer -> gamer.email().equals(email))
                .map(GamerDTO::id)
                .findFirst()
                .orElseThrow();

        webTestClient.delete()
                .uri(GAMER_PATH + "/{id}", id)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();

        webTestClient.get()
                .uri(GAMER_PATH + "/{id}", id)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isNotFound();
    }


    @Test
    void canUpdateGamer() {
        var faker = new Faker();
        Name fName = faker.name();

        String name = fName.fullName();
        String email = fName.lastName() + "-" + UUID.randomUUID() + "@whizhgames.com";
        int age = RANDOM.nextInt(1, 100);

        Gender gender = Gender.valueOf(age % 2 == 0 ? "MALE" : "FEMALE");

        var gamer = new Gamer(age, name, email, "password", gender.toString());



        var jwtToken = webTestClient.post()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamer), Gamer.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Void.class)
                .getResponseHeaders()
                .get(AUTHORIZATION)
                .get(0);

        List<GamerDTO> allGamers = webTestClient.get()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(new ParameterizedTypeReference<GamerDTO>() {
                })
                .returnResult()
                .getResponseBody();

        var id = allGamers.stream()
                .filter(gamer1 -> gamer1.email().equals(email))
                .map(GamerDTO::id)
                .findFirst()
                .orElseThrow();

        String newName = "Jumbo";

        Gamer gamerUpdate = new Gamer(newName, null, null);

        webTestClient.put()
                .uri(GAMER_PATH + "{/id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamerUpdate), Gamer.class)
                .exchange()
                .expectStatus()
                .isOk();

        GamerDTO updatedGamer = webTestClient.get()
                .uri(GAMER_PATH + "{/id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, String.format("Bearer %s", jwtToken))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(GamerDTO.class)
                .returnResult()
                .getResponseBody();

        GamerDTO expected = new GamerDTO(id, newName, email,  gender.toString(), age,List.of("ROLE_USER"), email);

        assertThat(gamerUpdate).isEqualTo(expected);
    }

}