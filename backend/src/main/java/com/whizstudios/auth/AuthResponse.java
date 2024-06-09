package com.whizstudios.auth;

import com.whizstudios.gamer.GamerDTO;

public record AuthResponse(GamerDTO gamerDTO, String token) {

}
