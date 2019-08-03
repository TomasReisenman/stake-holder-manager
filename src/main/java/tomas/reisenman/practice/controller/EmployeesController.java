package tomas.reisenman.practice.controller;

import tomas.reisenman.practice.dto.EmployeeDto;
import tomas.reisenman.practice.model.Employee;
import tomas.reisenman.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stakeholders/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity findAll(){

		return ResponseEntity.ok(employeeService
				.findAll()
				.stream()
				.map(EmployeeDto::new)
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Long id){

		return ResponseEntity.ok(new EmployeeDto(employeeService.findById(id)));
	}

	@PutMapping("/{id}")
	public ResponseEntity updateById(@PathVariable Long id,@RequestBody final Map<String,String> employee){

		return ResponseEntity.ok(new EmployeeDto(employeeService.updateEmployee(id,employee)));
	}

	@PostMapping()
	public ResponseEntity saveEmployee(@RequestBody final Employee employee){

		return ResponseEntity.status(HttpStatus.CREATED).body(new EmployeeDto(employeeService.saveEmployee(employee)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable Long id){

		employeeService.deleteById(id);

		return ResponseEntity.ok().build();
	}
	
}
