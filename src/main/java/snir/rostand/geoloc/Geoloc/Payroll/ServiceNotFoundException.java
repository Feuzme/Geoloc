package snir.rostand.geoloc.Geoloc.Payroll;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(Integer idService){
        super("Impossible de trouver le service "+idService);
    }
}
