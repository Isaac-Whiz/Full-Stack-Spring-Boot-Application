package com.example.full_stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FullStackApplicationTests extends AbstractUnitTests {


    @Test
    void itShouldStartPostgresDb() {
        //Given
        assertThat(postgreSQLContainer.isCreated()).isTrue();
        assertThat(postgreSQLContainer.isRunning()).isTrue();
//        assertThat(postgreSQLContainer.isHealthy()).isTrue();
        //When
        //Then
    }

}
