package com.whizstudios.gamer;

import java.util.List;

public record GamerDTO(
        Long id,
        String name,
        String email,
        String gender,
        Integer age,
        List<String> roles,
        String username
) {
}
