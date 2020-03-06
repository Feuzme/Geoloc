package snir.rostand.geoloc.Geoloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PiecesController {
    @Autowired
    PiecesRepository piecesRepo;
    @RequestMapping(method = RequestMethod.GET, path = "/pieces/list")
    public List getPieces(){
        return piecesRepo.findAll();
    }
}
