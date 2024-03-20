package com.whizstudios.gamer;

public record GamerUpdateRequest(
        String name,
        String email,
        int age
) {
}
