package snir.rostand.geoloc.Geoloc.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idPiece;
    @Column
    String nomPiece;
    @Column
    Integer Esp32id;
    @ManyToOne
    Service idService;
    @OneToOne
    Chariot chariot;
}
