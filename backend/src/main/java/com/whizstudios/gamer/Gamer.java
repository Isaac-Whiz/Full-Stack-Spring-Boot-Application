package com.whizstudios.gamer;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Gamer(long id, int age, String name, String email, Gender gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Gamer(int age, String name, String email, Gender gender) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Gamer(String name, String email) {
        this.name = name;
        this.email = email;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return id == gamer.id && age == gamer.age && Objects.equals(name, gamer.name) && Objects.equals(email, gamer.email) && gender == gamer.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, email, gender);
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
