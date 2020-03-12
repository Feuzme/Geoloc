package snir.rostand.geoloc.Geoloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.ServiceNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdateServiceDto;
import snir.rostand.geoloc.Geoloc.entity.Service;
import snir.rostand.geoloc.Geoloc.repository.ServicesRepository;

import java.util.List;

@RestController
public class ServicesController {
    @Autowired
    ServicesRepository servicesRepo;

    @GetMapping("/services/list")
    List getServices(){
        return servicesRepo.findAll();
    }

    @GetMapping("/services/{idService}")
    Service getServiceById(@PathVariable Integer idService){
        return servicesRepo.findById(idService)
                .orElseThrow(()->new ServiceNotFoundException(idService));
    }

    @PostMapping("/services")
    Service newService(@RequestBody CreateUpdateServiceDto dto){
        Service newService = new Service();
        newService.setNomService(dto.getNomService());
        return servicesRepo.save(newService);
    }

    @PutMapping("/services/{idService}")
    Service newService(@RequestBody CreateUpdateServiceDto dto, @PathVariable Integer idService){
        return servicesRepo.findById(idService)
                .map(
                        service -> {
                            service.setNomService(dto.getNomService());
                            return servicesRepo.save(service);
                        }
                ).orElseThrow(()->new ServiceNotFoundException(idService));
    }

    @DeleteMapping("/services/{idService}")
    void deleteService(@PathVariable Integer idService){
        servicesRepo.deleteById(idService);
    }
}
