package com.whizstudios.gamer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "gamer_email_unique", columnNames = "email")
})
//@AllArgsConstructor
@NoArgsConstructor
public class Gamer {
    @Id
    @SequenceGenerator(name = "gamer_id_generator", sequenceName = "gamer_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamer_id_generator")
    private long id;

    @Column(name = "age", nullable = false, columnDefinition = "NUMERIC")
    private int age;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    public Gamer(long id, int age, String name, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Gamer(int age, String name, String email) {
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Gamer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
