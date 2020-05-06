package ru.diasoft.micro.dqbiometricsid.exception;

import ru.diasoft.micro.dqbiometricsid.model.Error;

public class GenericException extends RuntimeException {

    private final Error error;

    public GenericException(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
