package snir.rostand.geoloc.Geoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import snir.rostand.geoloc.Geoloc.entity.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateAppChariotDto {
    String typeChariot;
    Integer idService;
    String macChariot;
}
