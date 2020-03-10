package snir.rostand.geoloc.Geoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snir.rostand.geoloc.Geoloc.entity.Utilisateur;

public interface UtilisateursRepository extends JpaRepository<Utilisateur, Integer> {
}
