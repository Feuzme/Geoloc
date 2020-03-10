package snir.rostand.geoloc.Geoloc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idUtilisateur;
    @Column
    String identifiant;
    @Column
    String motDePasse;
    @Column
    Integer permission;
    @OneToMany
    List<Reservation> reservations;
}
