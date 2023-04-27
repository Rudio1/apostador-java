package com.code.apostador;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

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
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado!");
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/verApostadores")
    public ResponseEntity<List<Apostador>> verApostador(){
        try {
            List<ApostadorBD> apostadorBDList = apostadorRepository.findAll();
            List<Apostador> apostadorList = new ArrayList<>();
            ModelMapper modelMapper = new ModelMapper();

            for(ApostadorBD apostadorBD: apostadorBDList ){
                Apostador apostador = modelMapper.map(apostadorBD, Apostador.class);
                apostadorList.add(apostador);
            }
            return ResponseEntity.status(HttpStatus.OK).body(apostadorList);
        } catch(Exception ex) {
            System.out.println("Exception occurred while getting apostadores: " + ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
