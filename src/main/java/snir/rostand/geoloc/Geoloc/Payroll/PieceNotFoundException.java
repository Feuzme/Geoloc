package snir.rostand.geoloc.Geoloc.Payroll;

public class PieceNotFoundException extends RuntimeException {
    public PieceNotFoundException(Integer idPiece){super("Impossible de trouver la piece "+idPiece);}
}
