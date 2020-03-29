package ru.diasoft.micro.dofacade.dto.error;

import lombok.Getter;
import ru.diasoft.micro.dofacade.model.Error;

@Getter
public class RecognitionErrorResponse extends GenericErrorResponse {

    private int photoId;

    public RecognitionErrorResponse(Error error, int photoId) {
        super(error);
        this.photoId = photoId;
    }
}
