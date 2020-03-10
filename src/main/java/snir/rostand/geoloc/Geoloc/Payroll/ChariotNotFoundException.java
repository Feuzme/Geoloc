package snir.rostand.geoloc.Geoloc.Payroll;

public class ChariotNotFoundException extends RuntimeException {
    public ChariotNotFoundException(Integer chariotId) {
        super("Impossible de trouver le chariot"+ chariotId);
    }
}
