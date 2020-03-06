package snir.rostand.geoloc.Geoloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateursController {
    @Autowired
    UtilisateursRepository utilisateursRepo;
    @RequestMapping (method = RequestMethod.GET, path = "/utilisateurs/list")
    public List getUtilisateurs(){
        return utilisateursRepo.findAll();
    }
}
