package snir.rostand.geoloc.Geoloc.Payroll;

public class UtilisateurNotFoundException extends RuntimeException{
    public UtilisateurNotFoundException(Integer idUtilisateur){super("Impossible de trouver l'utilisateur "+ idUtilisateur); }
}
