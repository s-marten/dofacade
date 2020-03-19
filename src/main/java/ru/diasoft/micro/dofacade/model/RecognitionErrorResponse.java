package ru.diasoft.micro.dofacade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecognitionErrorResponse {

    private int errorCode;

    private String errorText;

    private int photoId;

    public RecognitionErrorResponse(ErrorCases errorCase, int photoId) {
        errorCode = errorCase.errorCode;
        errorText = errorCase.errorText;
        this.photoId = photoId;
    }
}
