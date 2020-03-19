package ru.diasoft.micro.dofacade.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ErrorCases {

    COULDNT_DECODE(1, "Coldn't decode image"),
    UNEXPECTED_RECOGNITION_ERROR(2, "Unexpected recognition error");

    int errorCode;
    String errorText;
}
