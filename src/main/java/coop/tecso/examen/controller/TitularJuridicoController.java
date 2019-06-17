package coop.tecso.examen.controller;

import coop.tecso.examen.dto.TitularJuridicoDto;
import coop.tecso.examen.model.TitularJuridico;
import coop.tecso.examen.service.TitularJuridicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("titular/juridico")
public class TitularJuridicoController {

    private TitularJuridicoService titularJuridicoService;

    @Autowired
    public TitularJuridicoController(TitularJuridicoService titularJuridicoService) {
        this.titularJuridicoService = titularJuridicoService;
    }

    @GetMapping
    public ResponseEntity findAll(){

        return ResponseEntity.ok(titularJuridicoService
                .findAll()
                .stream()
                .map(TitularJuridicoDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        return ResponseEntity.ok(new TitularJuridicoDto(titularJuridicoService.findById(id)));
    }

    @PostMapping("/{id}")
    public ResponseEntity updateById(@PathVariable Long id,@RequestBody final Map<String,String> titularJuridico){

        return ResponseEntity.ok(new TitularJuridicoDto(titularJuridicoService.updateTitularJuridico(id,titularJuridico)));
    }

    @PostMapping()
    public ResponseEntity saveTitularJuridico(@RequestBody final TitularJuridico titularJuridico){

        return ResponseEntity.ok(new TitularJuridicoDto(titularJuridicoService.saveTitularJuridico(titularJuridico)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){

        titularJuridicoService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
