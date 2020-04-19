package ru.diasoft.micro.dofacade.exception;

import ru.diasoft.micro.dofacade.model.Error;

public class GenericException extends RuntimeException {

    private final Error error;

    public GenericException(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
