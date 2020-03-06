package snir.rostand.geoloc.Geoloc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idService;
    @Column
    String nomService;
}
