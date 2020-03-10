package snir.rostand.geoloc.Geoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snir.rostand.geoloc.Geoloc.entity.Service;

public interface ServicesRepository extends JpaRepository<Service, Integer> {
}
