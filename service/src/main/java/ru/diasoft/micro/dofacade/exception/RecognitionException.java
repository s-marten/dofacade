package ru.diasoft.micro.dofacade.exception;

import ru.diasoft.micro.dofacade.model.Error;

public class RecognitionException extends RuntimeException {

    private final Error error;
    private final int photoId;

    public RecognitionException(Error error, int photoId) {
        this.error = error;
        this.photoId = photoId;
    }

    public Error getError() {
        return error;
    }

    public int getPhotoId() {
        return photoId;
    }
}
