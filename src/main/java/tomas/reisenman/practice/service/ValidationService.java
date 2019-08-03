package tomas.reisenman.practice.service;

import tomas.reisenman.practice.model.StakeHolder;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Set;

@Service
public class ValidationService {


    public static void validateConstraints(final StakeHolder stakeHolder){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<StakeHolder>> violations = validator.validate(stakeHolder);

        if (!violations.isEmpty()) throw new ConstraintViolationException(violations);

    }
}
