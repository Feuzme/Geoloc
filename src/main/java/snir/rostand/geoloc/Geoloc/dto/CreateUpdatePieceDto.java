package snir.rostand.geoloc.Geoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdatePieceDto {
    String nomPiece;
    Integer Esp32id;
}
