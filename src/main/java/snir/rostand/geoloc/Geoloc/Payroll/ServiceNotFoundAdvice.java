package snir.rostand.geoloc.Geoloc.Payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ServiceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String serviceNotFoundhandler(ServiceNotFoundException ex){
        return ex.getMessage();
    }
}
