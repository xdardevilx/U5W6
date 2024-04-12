package valerio.U5W6.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dipendenti")
public class Dipendente {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String profileImage;

    @JsonIgnore
    @OneToMany(mappedBy = "dipendente")
    List<Dispositivo> dispositivi;


    public Dipendente(String name, String surname, String username, String email, String profileImage) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.profileImage = profileImage;
    }
}
