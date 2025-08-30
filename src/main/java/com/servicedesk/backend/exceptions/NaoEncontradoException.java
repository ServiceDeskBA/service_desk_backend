package com.servicedesk.backend.exceptions;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String message, char sufix) {
        super(message + " não encontrad" + sufix);
    }
}
