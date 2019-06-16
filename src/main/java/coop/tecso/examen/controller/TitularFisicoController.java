package coop.tecso.examen.controller;

import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.service.TitularFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/titular/fisico")
public class TitularFisicoController {

	private TitularFisicoService titularFisicoService;

	@Autowired
	public TitularFisicoController(TitularFisicoService titularFisicoService) {
		this.titularFisicoService = titularFisicoService;
	}

	@GetMapping
	public ResponseEntity findAll(){

		return ResponseEntity.ok(titularFisicoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Long id){

		return ResponseEntity.ok(titularFisicoService.findById(id));
	}

	@PostMapping("/{id}")
	public ResponseEntity updateById(@PathVariable Long id,@RequestBody final Map<String,String> titularFisico){

		return ResponseEntity.ok(titularFisicoService.updateTitularJuridico(id,titularFisico));
	}

	@PostMapping()
	public ResponseEntity saveTitularJuridico(@RequestBody final TitularFisico titularFisico){

		return ResponseEntity.ok(titularFisicoService.saveTitularJuridico(titularFisico));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable Long id){

		titularFisicoService.deleteById(id);

		return ResponseEntity.ok().build();
	}
	
}
