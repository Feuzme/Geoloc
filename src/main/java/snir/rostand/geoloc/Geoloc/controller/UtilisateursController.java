package snir.rostand.geoloc.Geoloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.UtilisateurNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdateUtilisateurDto;
import snir.rostand.geoloc.Geoloc.entity.Utilisateur;
import snir.rostand.geoloc.Geoloc.repository.UtilisateursRepository;

import java.util.List;

@RestController
public class UtilisateursController {
    @Autowired
    UtilisateursRepository utilisateursRepo;
    @GetMapping("/utilisateurs")
    public List getUtilisateurs(){
        return utilisateursRepo.findAll();
    }

    @GetMapping("/utilisateurs/{idUtilisateur]")
    public Utilisateur getUtilisateurById(@PathVariable Integer idUtilisateur){
        return  utilisateursRepo.findById(idUtilisateur)
                .orElseThrow(()-> new UtilisateurNotFoundException(idUtilisateur));
    }

    @PostMapping("/utilisateurs")
    Utilisateur newUtilisateur(@RequestBody CreateUpdateUtilisateurDto dto){
        Utilisateur newUtilisateur = new Utilisateur();
        newUtilisateur.setIdentifiant(dto.getIdentifiant());
        newUtilisateur.setMotDePasse(dto.getMotDePasse());
        newUtilisateur.setPermission(dto.getPermission());
        return utilisateursRepo.save(newUtilisateur);
    }

    @PutMapping("/utilisateur/app/{idUtilisateur}")
    Utilisateur newUtilisiteur(@PathVariable Integer idUtilisateur, @RequestBody CreateUpdateUtilisateurDto dto){
        return utilisateursRepo.findById(idUtilisateur)
                .map(
                        utilisateur -> {
                            utilisateur.setIdentifiant(dto.getIdentifiant());
                            utilisateur.setMotDePasse(dto.getMotDePasse());
                            utilisateur.setPermission(dto.getPermission());
                            return utilisateursRepo.save(utilisateur);
                        }
                ).orElseThrow(()->new UtilisateurNotFoundException(idUtilisateur));
    }

    @DeleteMapping("/utilisateurs/{idUtilisateur}")
    void deleteUtilisateur(@PathVariable Integer idUtilisateur)
    {
        utilisateursRepo.deleteById(idUtilisateur);
    }
}
