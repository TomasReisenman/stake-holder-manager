package coop.tecso.examen.controller;

import coop.tecso.examen.exceptions.InvalidCuitException;
import coop.tecso.examen.exceptions.TitularNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ InvalidCuitException.class})
    public final ResponseEntity handInvalidCuit(Exception e) {

        Map<String ,String > errorBody = new HashMap<>();
        errorBody.put("error",e.getMessage());
        errorBody.put("timestamp",LocalDate.now().toString());

        return new ResponseEntity(errorBody,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({ TitularNotFoundException.class})
    public final ResponseEntity handleNoHayTitular(Exception e) {

        Map<String ,String > errorBody = new HashMap<>();
        errorBody.put("error",e.getMessage());
        errorBody.put("timestamp",LocalDate.now().toString());

        return new ResponseEntity(errorBody,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({ ConstraintViolationException.class})
    public final ResponseEntity handleSQLException(ConstraintViolationException e) {

        Map<String ,String > errorBody = new HashMap<>();
        errorBody.put("error","Ese Cuit ya esta en la base de datos");
        errorBody.put("timestamp",LocalDate.now().toString());

        return new ResponseEntity(errorBody,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({ javax.validation.ConstraintViolationException.class})
    public final ResponseEntity handleConstraintException(javax.validation.ConstraintViolationException e) {

        Map<String ,String > errorBody = new HashMap<>();

        errorBody.put("errors", e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(" , ")));


        errorBody.put("timestamp",LocalDate.now().toString());

        return new ResponseEntity(errorBody,HttpStatus.BAD_REQUEST);

    }
}
