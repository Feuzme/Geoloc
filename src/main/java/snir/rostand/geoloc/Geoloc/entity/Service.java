package snir.rostand.geoloc.Geoloc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idService;
    @Column
    String nomService;
    @OneToMany
    List<Chariot> chariot;
    @OneToMany
    List<Piece> pieces;
}
