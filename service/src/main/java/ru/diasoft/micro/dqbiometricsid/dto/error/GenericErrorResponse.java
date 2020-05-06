package ru.diasoft.micro.dqbiometricsid.dto.error;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.diasoft.micro.dqbiometricsid.model.Error;

public class GenericErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    protected LocalDateTime timestamp = LocalDateTime.now();
    protected int code;
    protected String message;

    public GenericErrorResponse(Error error) {
        this.code = error.getCode();
        this.message = error.getText();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
