package org.example.back_end.exceptions;

import org.example.back_end.utill.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> HandleGenericException(Exception ex){
        return new ResponseEntity(new APIResponse(500,ex.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<APIResponse>handleResourceNotFoundException(ResourceNotFoundExceptions exceptions){
        return new ResponseEntity(new APIResponse(404,exceptions.getMessage(),null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyFoundException.class)
    public ResponseEntity<APIResponse> handleResourceAlreadyFoundException(ResourceAlreadyFoundException e) {
        return new ResponseEntity<>(new APIResponse(404,e.getMessage(),null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((fieldError)->{
                    errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(new APIResponse(400, "Validation Failed", errors),
                HttpStatus.BAD_REQUEST);
    }
}
