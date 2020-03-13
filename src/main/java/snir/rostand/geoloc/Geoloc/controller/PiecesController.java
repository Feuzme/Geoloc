package snir.rostand.geoloc.Geoloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.PieceNotFoundException;
import snir.rostand.geoloc.Geoloc.Payroll.ServiceNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.CreatePieceDto;
import snir.rostand.geoloc.Geoloc.dto.UpdatePieceDto;
import snir.rostand.geoloc.Geoloc.entity.Piece;
import snir.rostand.geoloc.Geoloc.entity.Service;
import snir.rostand.geoloc.Geoloc.repository.PiecesRepository;
import snir.rostand.geoloc.Geoloc.repository.ServicesRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PiecesController {
    @Autowired
    PiecesRepository piecesRepo;
    @Autowired
    ServicesRepository servicesRepo;
    //GET
    @GetMapping("/pieces/get/list")
    List getPieces() {
        return piecesRepo.findAll();
    }

    @GetMapping("/pieces/get/{idPiece}")
    Piece getPieceById(@PathVariable Integer idPiece) {
        return piecesRepo.findById(idPiece)
                .orElseThrow(() -> new PieceNotFoundException(idPiece));
    }

    //POST
    @PostMapping("/piece/post")
    Piece postPiece(@RequestBody CreatePieceDto dto){
        Piece newPiece = new Piece();
        Optional<Service>optService = servicesRepo.findById(dto.getIdService());
        if(!optService.isPresent()) {
            throw new ServiceNotFoundException(dto.getIdService());
        }
        newPiece.setIdService(optService.get());
        newPiece.setNomPiece(dto.getNomPiece());
        newPiece.setEsp32id(dto.getEsp32id());
        return piecesRepo.save(newPiece);
    }

    //PUT
    @PutMapping("/pieces/put/{idPiece}")
    Piece putPiece(@PathVariable Integer idPiece, @RequestBody UpdatePieceDto dto){
        return piecesRepo.findById(idPiece)
                .map(piece -> {
                    piece.setEsp32id(dto.getEsp32id());
                    return piecesRepo.save(piece);
                }).orElseThrow(()->new PieceNotFoundException(idPiece));
    }

    //DELETE
    @DeleteMapping("/pieces/delete/{idPiece}")
    void deletePiece(@PathVariable Integer idPiece){
        piecesRepo.deleteById(idPiece);
    }
}
