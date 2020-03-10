package snir.rostand.geoloc.Geoloc.Payroll;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Integer idReservation) {
        super("Impossible de trouver la reservation"+ idReservation);
    }
}
