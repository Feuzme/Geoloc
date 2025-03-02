package snir.rostand.geoloc.Geoloc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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
