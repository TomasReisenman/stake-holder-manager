package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;

import coop.tecso.examen.model.Titular;
import coop.tecso.examen.model.TitularFisico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import coop.tecso.examen.dto.CountryDto;
import coop.tecso.examen.repository.TitularFisicoRepo;

@RestController
@RequestMapping("/titular/fisico")
public class TitularFisicoController {

	@Autowired
	private TitularFisicoRepo titularFisicoRepo;
	
	// Get All Countries
	@GetMapping("/findAll")
	public List<TitularFisico> findAll() {
		
		/*List<CountryDto> result = new ArrayList<>();
		for (Titular entity : titularFisicoRepo.findAll()) {
			CountryDto dto = new CountryDto();
			dto.setId(entity.getId());
			dto.setIsoCode(entity.getIsoCode());
			dto.setName(entity.getName());
			
			result.add(dto);
		}*/
		
	    return titularFisicoRepo.findAll();
	}

	@PostMapping
	public ResponseEntity post(@RequestBody Titular object){



		return ResponseEntity.ok().build();
	}
	
}
