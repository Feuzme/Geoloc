package snir.rostand.geoloc.Geoloc.Payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
class ChariotNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ChariotNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String chariotNotFoundHandler(ChariotNotFoundException ex){
        return ex.getMessage();
    }
}
