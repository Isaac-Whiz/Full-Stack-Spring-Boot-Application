package com.whizstudios.security;

import com.whizstudios.jwt.JWTAuthenticationFilter;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JWTAuthenticationFilter authenticationFilter;
    private final AuthenticationEntryPoint authenticationEntryPoint;

    public SecurityFilterChainConfig(AuthenticationProvider authenticationProvider, JWTAuthenticationFilter authenticationFilter, AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationProvider = authenticationProvider;
        this.authenticationFilter = authenticationFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .csrf().disable()//Disabling cross site forgery
                .authorizeHttpRequests()//Allow http requests
                .requestMatchers(HttpMethod.POST, "/api/v1/gamers", "/api/v1/auth/login")//Post method on this url (end point)
                .permitAll()//Accept all requests
                .anyRequest()//Permit all requests
                .authenticated()//Authenticate the user (requests)
                .and()// Also session management
                .sessionManagement()//Disabling session management due to the use of JWT that provides expiring tokens
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Unmonitored sessions
                .and() // Also
                .authenticationProvider(authenticationProvider) // Add an authentication provider
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)// Add jwtAuthentication filter before user___password filter
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint);

        return httpSecurity.build();
    }
}
