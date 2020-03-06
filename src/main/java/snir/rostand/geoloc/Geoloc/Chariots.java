package snir.rostand.geoloc.Geoloc;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Chariots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idChariot;

    @Column
    String typeChariot;

    @Column
    Date dateDerniereLoc;

    @Column
    Integer idDernierePiece;

    @Column
    Integer idReservation;

    @Column
    Integer idServiceProprietaire;
}
