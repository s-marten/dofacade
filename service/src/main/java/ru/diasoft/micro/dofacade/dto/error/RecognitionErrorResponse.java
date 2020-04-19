package ru.diasoft.micro.dofacade.dto.error;

import ru.diasoft.micro.dofacade.model.Error;

public class RecognitionErrorResponse extends GenericErrorResponse {

    private int photoId;

    public RecognitionErrorResponse(Error error, int photoId) {
        super(error);
        this.photoId = photoId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
