package coop.tecso.examen.service;

import coop.tecso.examen.exceptions.TitularNotFoundException;
import coop.tecso.examen.model.TitularJuridico;
import coop.tecso.examen.repository.TitularJuridicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TitularJuridicoService {

    private TitularJuridicoRepo titularJuridicoRepo;
    private ValidationService validationService;

    @Autowired
    public TitularJuridicoService(TitularJuridicoRepo titularJuridicoRepo, ValidationService validationService) {
        this.titularJuridicoRepo = titularJuridicoRepo;
        this.validationService = validationService;
    }

    public List<TitularJuridico> findAll(){
        return titularJuridicoRepo.findAll();
    }

    public TitularJuridico findById(final Long id){
        return titularJuridicoRepo
                .findById(id)
                .orElseThrow(() -> new TitularNotFoundException("No hay un titular fisico con id: " + id ));
    }

    public TitularJuridico updateTitularJuridico(final Long id, final Map<String ,String > titularJuridico){

        TitularJuridico titularEncontrado = findById(id);

        titularEncontrado.setCuit(titularJuridico.getOrDefault("cuit",titularEncontrado.getCuit()));
        titularEncontrado.setRazonSocial(titularJuridico.getOrDefault("razonSocial",titularEncontrado.getRazonSocial()));
        titularEncontrado.setFoundationYear(titularJuridico.getOrDefault("foundationYear",titularEncontrado.getFoundationYear()));

        validationService.validateCuit(titularEncontrado);

        return titularJuridicoRepo.save(titularEncontrado);
    }

    public void deleteById(final Long id){
         titularJuridicoRepo.deleteById(id);
    }

    public TitularJuridico saveTitularJuridico(final TitularJuridico titularJuridico){

        validationService.validateCuit(titularJuridico);

        return titularJuridicoRepo.save(titularJuridico);
    }




}
