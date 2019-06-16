package coop.tecso.examen.controller;

import coop.tecso.examen.exceptions.InvalidCuitException;
import coop.tecso.examen.exceptions.TitularNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
}
