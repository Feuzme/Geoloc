package snir.rostand.geoloc.Geoloc.controller;

//import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.ChariotNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.UpdateEspChariotDto;
import snir.rostand.geoloc.Geoloc.repository.ChariotsRepository;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdateAppChariotDto;
import snir.rostand.geoloc.Geoloc.entity.Chariot;

import java.util.List;

@RestController
public class ChariotsController {
    @Autowired
    ChariotsRepository chariotsRepo;

    @GetMapping("/chariots")
    List getChariots(){
        return chariotsRepo.findAll();
    }

    @GetMapping("/chariots/{idChariot}")
    Chariot getChariotById(@PathVariable Integer idChariot){
        return chariotsRepo.findById(idChariot)
                .orElseThrow(()->new ChariotNotFoundException(idChariot));
    }

    @PostMapping("/chariots")
    Chariot newCharriot(@RequestBody CreateUpdateAppChariotDto dto){
            Chariot newChariot = new Chariot();
            newChariot.setServiceProprietaire(dto.getServiceProprietaire());
            newChariot.setTypeChariot(dto.getTypeChariot());
            newChariot.setMacBeacon(dto.getMacChariot());
            return chariotsRepo.save(newChariot);
    }

    @PutMapping("/chariots/app/{chariotId}")
    Chariot remplaceChariot(@RequestBody CreateUpdateAppChariotDto dto, @PathVariable Integer chariotId){
        return chariotsRepo.findById(chariotId)
                .map(chariot -> {
                    chariot.setTypeChariot(dto.getTypeChariot());
                    chariot.setServiceProprietaire(dto.getServiceProprietaire());
                    return chariotsRepo.save(chariot);
                })
                .orElseThrow(()->new ChariotNotFoundException(chariotId));
    }
    @PutMapping("/chariots/esp/{chariotId}")
    Chariot updateChariot(@RequestBody UpdateEspChariotDto dto, @PathVariable Integer chariotId){
        return chariotsRepo.findById(chariotId)
                .map(chariot -> {
                    chariot.setDateDerniereLoc(dto.getDateDerniereLoc());
                    chariot.setDernierePiece(dto.getDernierePiece());
                    return chariotsRepo.save(chariot);
                })
                .orElseThrow(()->new ChariotNotFoundException(chariotId));
    }

    @DeleteMapping("/chariot/{chariotId}")
    void deleteChariot(@PathVariable Integer chariotId){
            chariotsRepo.deleteById(chariotId);
    }
}
