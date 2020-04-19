package ru.diasoft.micro.dofacade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    INTERNAL(0, "Internal server error"),
    INPUT_PARAMS_VALIDATION_ERROR(1, "Input parameters validation error"),
    COULDNT_DECODE(2, "Coldn't decode image"),
    UNEXPECTED_RECOGNITION_ERROR(3, "Unexpected recognition error");

    private int code;
    private String text;

    Error(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
