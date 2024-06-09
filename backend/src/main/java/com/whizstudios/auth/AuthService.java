package com.whizstudios.auth;

import com.whizstudios.gamer.Gamer;
import com.whizstudios.gamer.GamerDTO;
import com.whizstudios.gamer.GamerDTOMapper;
import com.whizstudios.jwt.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final GamerDTOMapper dtoMapper;
    private final JWTUtil jwtUtil;

    public AuthService(AuthenticationManager authenticationManager, GamerDTOMapper dtoMapper, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.dtoMapper = dtoMapper;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(),
                request.password()
        ));

        Gamer principal = (Gamer) authentication.getPrincipal();
        GamerDTO gamerDTO = dtoMapper.apply(principal);
        String token = jwtUtil.issueToken(gamerDTO.username(), gamerDTO.roles());

        return new AuthResponse(gamerDTO, token);
    }
}
