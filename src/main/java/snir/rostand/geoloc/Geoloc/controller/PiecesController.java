package snir.rostand.geoloc.Geoloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snir.rostand.geoloc.Geoloc.Payroll.PieceNotFoundException;
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
    Piece postPieces()
}
