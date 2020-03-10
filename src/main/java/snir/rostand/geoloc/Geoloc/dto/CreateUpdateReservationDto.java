package snir.rostand.geoloc.Geoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateReservationDto {
    Timestamp dateDebutReservation;
    Timestamp dateFinReservation;
    String typeReservation;
}
