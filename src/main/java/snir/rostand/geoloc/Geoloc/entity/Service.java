package snir.rostand.geoloc.Geoloc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idService;
    @Column
    String nomService;
    @OneToOne
    Chariot chariot;
    @OneToMany
    List<Piece> pieces;
}
