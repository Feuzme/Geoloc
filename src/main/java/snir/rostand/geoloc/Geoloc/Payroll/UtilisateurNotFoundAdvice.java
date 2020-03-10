package snir.rostand.geoloc.Geoloc.Payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UtilisateurNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UtilisateurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String utilisateurNotFoundHandler(UtilisateurNotFoundException ex)
    {return ex.getMessage();}
}
