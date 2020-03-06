package snir.rostand.geoloc.Geoloc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idUtilisateur;
    @Column
    String identifiant;
    @Column
    String motDePass;
    @Column
    Integer permission;
}
