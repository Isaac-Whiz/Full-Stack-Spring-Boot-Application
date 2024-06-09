package com.whizstudios.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class JWTUtil {

    private final String SECRET_KEY = "rttttttttttydfbfgbbcfmdfnsndfdsfnsfanfosrnrgonfmigrrignkfnnsdnfdnjkrnfsfkdfofgssjgssfnnsffnnafnsdnfngfjnfsfgfnjfnfbbvndfdifjsigjsi";
    
    public String issueToken(String subject) {
        return issueToken(subject, Map.of());
    }

   public String issueToken(String subject, String ...scopes) {
        return issueToken(subject, Map.of("scopes", scopes));
    }

    public String issueToken(String subject, List<String> scopes) {
        return issueToken(subject, Map.of("scopes", scopes));
    }

    private String issueToken(String subject, Map<String, Object> claims) {
        return Jwts
                .builder()
                .setClaims(claims) // Order matters
                .setSubject(subject)
                .setIssuer("https://isaacwhiz.com")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(10, ChronoUnit.DAYS))).signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String getSubjects(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String jwt, String username) {
        String subject = getSubjects(jwt);
        return subject.equals(username) && !isTokenExpired(jwt);
    }

    private boolean isTokenExpired(String jwt) {
        Date today = Date.from(Instant.now());
        return getClaims(jwt).getExpiration().before(today);
    }
}
