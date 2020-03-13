package snir.rostand.geoloc.Geoloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdateReservationDto;
import snir.rostand.geoloc.Geoloc.entity.Reservation;
import snir.rostand.geoloc.Geoloc.Payroll.ReservationNotFoundException;
import snir.rostand.geoloc.Geoloc.repository.ReservationsRepository;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationsRepository reservationsRepo;
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
