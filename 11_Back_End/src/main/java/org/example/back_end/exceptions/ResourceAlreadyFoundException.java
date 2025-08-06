package org.example.back_end.exceptions;

public class ResourceAlreadyFoundException extends RuntimeException {
    public ResourceAlreadyFoundException(String s) {
        super(s);
    }
}