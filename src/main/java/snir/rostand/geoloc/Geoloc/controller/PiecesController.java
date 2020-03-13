package snir.rostand.geoloc.Geoloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.PieceNotFoundException;
import snir.rostand.geoloc.Geoloc.dto.CreateUpdatePieceDto;
import snir.rostand.geoloc.Geoloc.entity.Piece;
import snir.rostand.geoloc.Geoloc.repository.PiecesRepository;

import java.util.List;

@RestController
public class PiecesController {
    @Autowired
    PiecesRepository piecesRepo;

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
    Piece postPiece(@RequestBody CreateUpdatePieceDto dto){
        Piece newPiece = new Piece();
        newPiece.setNomPiece(dto.getNomPiece());
        newPiece.setEsp32id(dto.getEsp32id());
        return piecesRepo.save(newPiece);
    }

    //PUT
    @PutMapping("/pieces/put/{idPiece}")
    Piece putPiece(@PathVariable Integer idPiece, @RequestBody CreateUpdatePieceDto dto){
        return piecesRepo.findById(idPiece)
                .map(piece -> {
                    piece.setNomPiece(dto.getNomPiece());
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
