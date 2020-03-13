package snir.rostand.geoloc.Geoloc.Payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class PieceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PieceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pieceNotFoundHandler(PieceNotFoundException ex){return ex.getMessage();}

}
