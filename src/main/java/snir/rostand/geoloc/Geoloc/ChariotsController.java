package snir.rostand.geoloc.Geoloc;

//import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
public class ChariotsController {
    @Autowired
    ChariotsRepository chariotsRepo;

    @GetMapping("/chariots/")
    List getChariots(){
        return chariotsRepo.findAll();
    }

    @GetMapping("/chariots/{chariotId}")
    Chariots getChariotById(@PathVariable Integer chariotId){
        return chariotsRepo.findById(chariotId)
                .orElseThrow(()->new ChariotNotFoundExeption(chariotId));
    }

    @PostMapping("/chariot/")
    Chariots newCharriot(@RequestBody Chariots newChariot){
        return chariotsRepo.save(newChariot);
    }

    @PutMapping("/chariot/{chariotId}")
    Chariots remplaceChariot(@RequestBody Chariots newChariot, @PathVariable Integer idChariot){
        return chariotsRepo.findById(idChariot)
                .map(chariots -> {
                    chariots.setIdChariot(newChariot.getIdChariot());
                    chariots.setTypeChariot(newChariot.getTypeChariot());
                    chariots.setDateDerniereLoc(Date.from(Instant.now()));
                    chariots.setIdDernierePiece(0);
                    chariots.setIdReservation(0);
                    chariots.setIdReservation(0);
                    return chariotsRepo.save(chariots);
                })
                .orElseGet(()->{
                    newChariot.setIdChariot(idChariot);
                    return chariotsRepo.save(newChariot);
                });
    }

    @DeleteMapping("/chariot/{chariotId}")
    void deleteChariot(@PathVariable Integer chariotId){
        //try {
            chariotsRepo.deleteById(chariotId);
        //}
        /*catch (Error e){
            System.out.println(e.getMessage());
        }*/
    }
}
