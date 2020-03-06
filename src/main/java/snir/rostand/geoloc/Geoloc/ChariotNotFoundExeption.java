package snir.rostand.geoloc.Geoloc;

public class ChariotNotFoundExeption extends RuntimeException {
    public ChariotNotFoundExeption(Integer chariotId) {
        super("Impossible de trouver le chariot"+ chariotId);
    }
}
