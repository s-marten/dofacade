package ru.diasoft.micro.dofacade.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.diasoft.micro.dofacade.model.Error;

@Getter
@AllArgsConstructor
public class RecognitionException extends RuntimeException {

    private Error error;
    private int photoId;
}
