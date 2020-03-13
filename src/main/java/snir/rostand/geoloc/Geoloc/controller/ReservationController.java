package snir.rostand.geoloc.Geoloc.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.ChariotNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdateReservationDto;
import snir.rostand.geoloc.Geoloc.entity.Chariot;
import snir.rostand.geoloc.Geoloc.entity.Reservation;
import snir.rostand.geoloc.Geoloc.Payroll.ReservationNotFoundException;
import snir.rostand.geoloc.Geoloc.repository.ChariotsRepository;
import snir.rostand.geoloc.Geoloc.repository.ReservationsRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {
    @Autowired
    ReservationsRepository reservationsRepo;
    @Autowired
    ChariotsRepository chariotsRepo;
    //GET
    @GetMapping("/reservations/get/list")
    List getReservations(){
        return reservationsRepo.findAll();
    }

    @GetMapping("/reservations/get/{idReservation}")
    Reservation getReservation(@PathVariable Integer idReservation){
        return reservationsRepo.findById(idReservation)
                .orElseThrow(()->new ReservationNotFoundException(idReservation));
    }
    //POST
    @PostMapping("/reservations/post")
    Reservation newReservation(@RequestBody CreateUpdateReservationDto dto){
        Reservation newReservation = new Reservation();
        Optional<Chariot> optChariot = chariotsRepo.findById(dto.getIdChariot());
        if(!optChariot.isPresent())
            throw new ChariotNotFoundException(dto.getIdChariot());
        newReservation.setChariot(optChariot.get());
        newReservation.setDateDebutReservation(dto.getDateDebutReservation());
        newReservation.setDateFinReservation(dto.getDateFinReservation());
        newReservation.setTypeReservation(dto.getTypeReservation());
        return reservationsRepo.save(newReservation);
    }
    //PUT
    @PutMapping("/reservations/put/{idReservation}")
    Reservation remplaceReservation(@RequestBody CreateUpdateReservationDto dto, @PathVariable Integer idReservation){
        return reservationsRepo.findById(idReservation)
                .map(reservation -> {
                    Optional<Chariot> optChariot = chariotsRepo.findById(dto.getIdChariot());
                    if(!optChariot.isPresent())
                        throw new ChariotNotFoundException(dto.getIdChariot());
                    reservation.setChariot(optChariot.get());
                    reservation.setTypeReservation(dto.getTypeReservation());
                    reservation.setDateDebutReservation(dto.getDateDebutReservation());
                    reservation.setDateFinReservation(dto.getDateFinReservation());
                    return reservationsRepo.save(reservation);
                })
                .orElseThrow(()->new ReservationNotFoundException(idReservation));
    }
    //DELETE
    @DeleteMapping("/reservattions/delete/{idReservation}")
    void deleteReservation(@PathVariable Integer idReservation){
        reservationsRepo.deleteById(idReservation);
    }
}
