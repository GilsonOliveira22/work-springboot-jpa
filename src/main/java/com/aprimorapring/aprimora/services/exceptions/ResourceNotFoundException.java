package com.aprimorapring.aprimora.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Recursos não encontrados para o " + id);
    }
}
