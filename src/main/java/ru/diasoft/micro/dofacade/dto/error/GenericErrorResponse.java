package ru.diasoft.micro.dofacade.dto.error;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.diasoft.micro.dofacade.model.Error;

@Data
public class GenericErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    protected LocalDateTime timestamp = LocalDateTime.now();
    protected int code;
    protected String message;

    public GenericErrorResponse(Error error) {
        this.code = error.getCode();
        this.message = error.getText();
    }
}
