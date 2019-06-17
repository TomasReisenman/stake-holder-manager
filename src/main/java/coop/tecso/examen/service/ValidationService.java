package coop.tecso.examen.service;

import coop.tecso.examen.model.Titular;
import coop.tecso.examen.repository.TitularFisicoRepo;
import coop.tecso.examen.repository.TitularJuridicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Set;

@Service
public class ValidationService {

    private TitularFisicoRepo titularFisicoRepo;
    private TitularJuridicoRepo titularJuridicoRepo;

    @Autowired
    public ValidationService(TitularFisicoRepo titularFisicoRepo, TitularJuridicoRepo titularJuridicoRepo) {
        this.titularFisicoRepo = titularFisicoRepo;
        this.titularJuridicoRepo = titularJuridicoRepo;
    }

    public void validateConstraints(final Titular titular){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Titular>> violations = validator.validate(titular);

        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);

    }
}