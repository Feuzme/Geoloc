package snir.rostand.geoloc.Geoloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationsRepository reservationsRepo;
    @RequestMapping(method = RequestMethod.GET, path = "/reservations/list")
    public List getReservations(){
        return reservationsRepo.findAll();
    }
}
