package snir.rostand.geoloc.Geoloc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idReservation;
    @Column
    Timestamp dateDebutReservation;
    @Column
    Timestamp dateFinReservation;
    @Column
    String typeReservation;
    @ManyToOne
    Utilisateur utilisateur;
    @ManyToOne
    Chariot chariot;
}
