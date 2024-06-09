package com.whizstudios.gamer;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "gamer_email_unique", columnNames = "email")
})
@NoArgsConstructor
public class Gamer implements UserDetails {
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
    private String gender;

    @Column(name = "password", nullable = false)
    private String password;

    public Gamer(long id, int age, String name, String email, String password, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Gamer(int age, String name, String email, String password, String gender) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
    public Gamer(int age, String name, String email, String password) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Gamer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
