package snir.rostand.geoloc.Geoloc;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pieces {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idPiece;
    @Column
    String nomPiece;
    @Column
    Integer Esp32id;
    @Column
    Integer idService;
}
