package snir.rostand.geoloc.Geoloc.Payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String serviceNotFoundhandler(ServiceNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ChariotNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String chariotNotFoundHandler(ChariotNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PieceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pieceNotFoundHandler(PieceNotFoundException ex){return ex.getMessage();}

    @ResponseBody
    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reservationNotFoundHandler(ReservationNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UtilisateurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String utilisateurNotFoundHandler(UtilisateurNotFoundException ex)
    {return ex.getMessage();}
}
