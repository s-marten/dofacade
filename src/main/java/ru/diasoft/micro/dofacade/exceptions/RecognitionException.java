package ru.diasoft.micro.dofacade.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RecognitionException extends Exception {

    private int photoId;

    private String sdkErrorText;
}
