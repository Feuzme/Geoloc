package snir.rostand.geoloc.Geoloc.controller;

//import jdk.jfr.Frequency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.ChariotNotFoundException;
import snir.rostand.geoloc.Geoloc.Payroll.ServiceNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.UpdateEspChariotDto;
import snir.rostand.geoloc.Geoloc.entity.Service;
import snir.rostand.geoloc.Geoloc.repository.ChariotsRepository;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdateAppChariotDto;
import snir.rostand.geoloc.Geoloc.entity.Chariot;
import snir.rostand.geoloc.Geoloc.repository.ServicesRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ChariotsController {
    @Autowired
    ChariotsRepository chariotsRepo;
    @Autowired
    ServicesRepository serviceRepo;

    @GetMapping("/chariots/get/list")
    List getChariots() {
        return chariotsRepo.findAll();
    }

    @GetMapping("/chariots/get/{idChariot}")
    Chariot getChariotById(@PathVariable Integer idChariot) {
        return chariotsRepo.findById(idChariot)
                .orElseThrow(() -> new ChariotNotFoundException(idChariot));
    }

    @PostMapping("/chariots/post")
    Chariot newCharriot(@RequestBody CreateUpdateAppChariotDto dto) {
        Chariot newChariot = new Chariot();
        Optional<Service> optService = serviceRepo.findById(dto.getIdService());
        if (!optService.isPresent()) {
            throw new ServiceNotFoundException(dto.getIdService());
        }
        newChariot.setServiceProprietaire(optService.get());
        newChariot.setTypeChariot(dto.getTypeChariot());
        newChariot.setMacBeacon(dto.getMacChariot());
        return chariotsRepo.save(newChariot);

    }

    @PutMapping("/chariots/put/app/{chariotId}")
    Chariot remplaceChariot(@RequestBody CreateUpdateAppChariotDto dto, @PathVariable Integer chariotId) {
        return chariotsRepo.findById(chariotId)
                .map(chariot -> {
                    chariot.setTypeChariot(dto.getTypeChariot());
                    chariot.setServiceProprietaire(serviceRepo.getOne(dto.getIdService()));
                    return chariotsRepo.save(chariot);
                })
                .orElseThrow(() -> new ChariotNotFoundException(chariotId));
    }

    @PutMapping("/chariots/put/esp/{chariotId}")
    Chariot updateChariot(@RequestBody UpdateEspChariotDto dto, @PathVariable Integer chariotId) {
        return chariotsRepo.findById(chariotId)
                .map(chariot -> {
                    chariot.setDateDerniereLoc(dto.getDateDerniereLoc());
                    chariot.setDernierePiece(dto.getDernierePiece());
                    return chariotsRepo.save(chariot);
                })
                .orElseThrow(() -> new ChariotNotFoundException(chariotId));
    }

    @DeleteMapping("/chariot/delete/{chariotId}")
    void deleteChariot(@PathVariable Integer chariotId) {
        chariotsRepo.deleteById(chariotId);
    }
}
