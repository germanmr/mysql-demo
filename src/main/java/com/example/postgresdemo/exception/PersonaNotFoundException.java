package com.example.postgresdemo.exception;

public class PersonaNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    private String mensaje;

    public PersonaNotFoundException(String mensaje) {
        super(mensaje);

    }

}
