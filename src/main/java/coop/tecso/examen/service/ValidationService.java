package coop.tecso.examen.service;

import coop.tecso.examen.model.Titular;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Set;

@Service
public class ValidationService {


    public static void validateConstraints(final Titular titular){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Titular>> violations = validator.validate(titular);

        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);

    }
}
