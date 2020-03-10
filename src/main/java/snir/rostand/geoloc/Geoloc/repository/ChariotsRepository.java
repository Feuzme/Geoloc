package snir.rostand.geoloc.Geoloc.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import snir.rostand.geoloc.Geoloc.entity.Chariot;

public interface ChariotsRepository extends JpaRepository<Chariot, Integer> {
}
