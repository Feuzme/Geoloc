package snir.rostand.geoloc.Geoloc.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Chariot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idChariot;

    @Column
    String macBeacon;

    @Column
    String typeChariot;

    @Column
    Date dateDerniereLoc;

    @OneToOne
    Piece dernierePiece;

    @OneToMany
    List<Reservation> reservation;

    @ManyToOne
    Service serviceProprietaire;
}
