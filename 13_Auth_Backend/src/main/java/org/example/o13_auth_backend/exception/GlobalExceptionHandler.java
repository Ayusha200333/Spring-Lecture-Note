package org.example.o13_auth_backend.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.example.o13_auth_backend.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIResponse handleUserNameNotFoundException(UsernameNotFoundException ex){
        return new APIResponse(404,"User not found",null);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIResponse handleBadCredentials(BadCredentialsException ex){
        return new APIResponse(400, "Bad Credentials",null);
    }

    // Exception Handler for JWT Token Expired Exception
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleJWTTokenExpiredException(ExpiredJwtException ex){
        return new APIResponse(401, "JWT Token Expired",null);
    }
    // Exception Handler for all other exceptions
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIResponse handleAllExceptions(RuntimeException ex){
        return new APIResponse(500, "Internal Server Error",null);
    }
}
