package snir.rostand.geoloc.Geoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snir.rostand.geoloc.Geoloc.entity.Piece;

public interface PiecesRepository extends JpaRepository<Piece, Integer> {
}
