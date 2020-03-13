package snir.rostand.geoloc.Geoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import snir.rostand.geoloc.Geoloc.entity.Piece;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateServiceDto {
    String nomService;
}
