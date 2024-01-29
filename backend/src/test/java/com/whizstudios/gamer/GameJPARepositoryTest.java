//package com.whizstudios.gamer;
//
//import com.example.full_stack.AbstractUnitTests;
//import jakarta.activation.DataSource;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class GameJPARepositoryTest extends AbstractUnitTests {
//
////    @TestConfiguration
////    static class TestConfig {
////
////        @Bean
////        public DataSource dataSource() {
////            // Configure and return your DataSource with specific authentication credentials
//////            DataSource dataSource = DataSource().
//////            dataSource.setDriverClassName("your.driver.class");
//////            dataSource.setUrl("your.jdbc.url");
//////            dataSource.setUsername("your_username");
//////            dataSource.setPassword("your_password");
////            return dataSource;
////        }
////    }
//
//    @Autowired
//    private GamerRepository gamerRepository;
//
//    @BeforeEach
//    void setUp() {
//
//    }
//
//    @Test
//    void itShouldExistsGamerByEmail() {
//        //Given
//        //When
//        //Then
//    }
//
//    @Test
//    void itShouldExistsById() {
//        //Given
//        //When
//        //Then
//    }
//}