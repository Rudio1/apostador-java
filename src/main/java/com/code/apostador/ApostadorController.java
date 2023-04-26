package com.code.apostador;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApostadorController {

    private final ApostadorBDRepository apostadorRepository;

    public ApostadorController(ApostadorBDRepository apostadorRepository) {
        this.apostadorRepository = apostadorRepository;
    }

    @PostMapping("/apostador")
    public ResponseEntity salvarApostador(@RequestBody Apostador apostador){
        try {
            ApostadorBD apostadorBD = apostador.toConvert();
            apostadorRepository.save(apostadorBD);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
