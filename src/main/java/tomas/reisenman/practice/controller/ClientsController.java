package tomas.reisenman.practice.controller;

import tomas.reisenman.practice.dto.ClientDto;
import tomas.reisenman.practice.model.Client;
import tomas.reisenman.practice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("stakeholders/clients")
@CrossOrigin
public class ClientsController {

    private ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity findAll(){

        return ResponseEntity.ok(clientService
                .findAll()
                .stream()
                .map(ClientDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        return ResponseEntity.ok(new ClientDto(clientService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable Long id,@RequestBody final Map<String,String> client){

        return ResponseEntity.ok(new ClientDto(clientService.updateClient(id,client)));
    }

    @PostMapping()
    public ResponseEntity saveClient(@RequestBody final Client client){

        return ResponseEntity.ok(new ClientDto(clientService.saveClient(client)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){

        clientService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
