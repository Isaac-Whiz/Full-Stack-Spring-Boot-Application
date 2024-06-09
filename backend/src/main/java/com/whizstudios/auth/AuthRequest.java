package com.whizstudios.auth;

public record AuthRequest(
        String username,
        String password
) {
}
