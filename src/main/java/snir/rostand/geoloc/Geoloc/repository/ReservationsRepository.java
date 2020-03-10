package snir.rostand.geoloc.Geoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snir.rostand.geoloc.Geoloc.entity.Reservation;

public interface ReservationsRepository extends JpaRepository<Reservation, Integer> {
}
