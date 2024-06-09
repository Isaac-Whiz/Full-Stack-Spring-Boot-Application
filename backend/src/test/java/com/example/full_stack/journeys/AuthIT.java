package com.example.full_stack.journeys;

import com.whizstudios.auth.AuthRequest;
import com.whizstudios.auth.AuthResponse;
import com.whizstudios.gamer.Gamer;
import com.whizstudios.gamer.GamerDTO;
import com.whizstudios.gamer.Gender;
import com.whizstudios.jwt.JWTUtil;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AuthIT {
    @Autowired
    private WebTestClient webTestClient;

    private  final JWTUtil jwtUtil;

    private static final Random RANDOM  = new Random();
    private static final String AUTH_PATH = "/api/v1/auth";
    private static final String GAMER_PATH = "/api/v1/gamers";

    public AuthIT(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Test
    void canLogin() {
        //Given
        Faker faker = new Faker();
        Name fakerName = faker.name();

        String name = fakerName.fullName();
        String email = fakerName.lastName() + "-" + UUID.randomUUID() + "@whiz.com";
        int age = RANDOM.nextInt(1, 100);

        Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;

        var password = "password";
        Gamer gamer = new Gamer(age, name, email, password, gender.toString());

        AuthRequest authRequest = new AuthRequest(email, password);

        webTestClient.post()
                .uri(AUTH_PATH + "/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(authRequest), AuthRequest.class)
                .exchange()
                .expectStatus()
                .isUnauthorized();


        webTestClient.post()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamer), Gamer.class)
                .exchange()
                .expectStatus()
                .isCreated();

        EntityExchangeResult<AuthResponse> result = webTestClient.post()
                .uri(GAMER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(gamer), Gamer.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<AuthResponse>() {
                }).returnResult();

        var token = result.getResponseHeaders().get(AUTHORIZATION).get(0);

        var authResponse = result.getResponseBody();

        GamerDTO gamerDTO = authResponse.gamerDTO();

        assertThat(jwtUtil.isTokenValid(token, gamerDTO.username()));

        assertThat(gamerDTO.email()).isEqualTo(email);
        assertThat(gamerDTO.age()).isEqualTo(age);
        assertThat(gamerDTO.name()).isEqualTo(name);
        assertThat(gamerDTO.username()).isEqualTo(email);
        assertThat(gamerDTO.gender()).isEqualTo(gender);
        assertThat(gamerDTO.roles()).isEqualTo(List.of("ROLE_USER"));
    }
}
