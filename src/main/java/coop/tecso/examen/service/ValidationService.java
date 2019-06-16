package coop.tecso.examen.service;

import coop.tecso.examen.exceptions.InvalidCuitException;
import coop.tecso.examen.model.Titular;
import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.model.TitularJuridico;
import coop.tecso.examen.repository.TitularFisicoRepo;
import coop.tecso.examen.repository.TitularJuridicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    private TitularFisicoRepo titularFisicoRepo;
    private TitularJuridicoRepo titularJuridicoRepo;

    @Autowired
    public ValidationService(TitularFisicoRepo titularFisicoRepo, TitularJuridicoRepo titularJuridicoRepo) {
        this.titularFisicoRepo = titularFisicoRepo;
        this.titularJuridicoRepo = titularJuridicoRepo;
    }

    public void validateCuit(final Titular titular){

        String cuitObteined = titular.getCuit();
        Optional<TitularFisico> titularFisico = titularFisicoRepo.findByCuit(cuitObteined);
        Optional<TitularJuridico> titularJuridico = titularJuridicoRepo.findByCuit(cuitObteined);

        if(titularFisico.isPresent() && !(titular instanceof TitularFisico && titularFisico.get().getId().equals(titular.getId()))){

            throw new InvalidCuitException("El cuit: " + cuitObteined + " ya se encuentra en la base de datos");
        }

        if(titularJuridico.isPresent() && !(titular instanceof TitularJuridico && titularJuridico.get().getId().equals(titular.getId()))) {

            throw new InvalidCuitException("El cuit: " + cuitObteined + " ya se encuentra en la base de datos");
        }
    }
}
