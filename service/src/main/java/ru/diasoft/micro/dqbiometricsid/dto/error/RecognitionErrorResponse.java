package ru.diasoft.micro.dqbiometricsid.dto.error;

import ru.diasoft.micro.dqbiometricsid.model.Error;

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
