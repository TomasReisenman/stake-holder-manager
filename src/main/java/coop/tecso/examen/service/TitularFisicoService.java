package coop.tecso.examen.service;

import coop.tecso.examen.exceptions.TitularNotFoundException;
import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.repository.TitularFisicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TitularFisicoService {

    private TitularFisicoRepo titularFisicoRepo;
    private ValidationService validationService;

    @Autowired
    public TitularFisicoService(TitularFisicoRepo titularFisicoRepo, ValidationService validationService) {
        this.titularFisicoRepo = titularFisicoRepo;
        this.validationService = validationService;
    }


    public List<TitularFisico> findAll(){
        return titularFisicoRepo.findAll();
    }

    public TitularFisico findById(final Long id){
        return titularFisicoRepo
                .findById(id)
                .orElseThrow(() -> new TitularNotFoundException("No hay un titular fisico con id:" + id));
    }

    public TitularFisico updateTitularJuridico(final Long id, final Map<String ,String > titularFisico){

        TitularFisico titularEncontrado = findById(id);

        titularEncontrado.setCuit(titularFisico.getOrDefault("cuit",titularEncontrado.getCuit()));
        titularEncontrado.setNombre(titularFisico.getOrDefault("nombre",titularEncontrado.getNombre()));
        titularEncontrado.setApellido(titularFisico.getOrDefault("apellido",titularEncontrado.getApellido()));
        titularEncontrado.setDni(titularFisico.getOrDefault("dni",titularEncontrado.getDni()));

        validationService.validateConstraints(titularEncontrado);

        return titularFisicoRepo.save(titularEncontrado);
    }

    public void deleteById(final Long id){
        titularFisicoRepo.deleteById(id);
    }

    public TitularFisico saveTitularJuridico(final TitularFisico titularFisico){

        validationService.validateConstraints(titularFisico);

        return titularFisicoRepo.save(titularFisico);
    }





}
