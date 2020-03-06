package snir.rostand.geoloc.Geoloc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idReservation;
    @Column
    Timestamp dateDebutReservation;
    @Column
    Timestamp dateFinReservation;
    @Column
    Integer idUtilisateur;
    @Column
    String typeReservation;
}
