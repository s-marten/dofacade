package ru.diasoft.micro.dofacade.dto.error;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import ru.diasoft.micro.dofacade.model.Error;

@Getter
@Setter
public class InputParamsValidationErrorReponse extends GenericErrorResponse {

    private List<String> inputParamErrors;

    public InputParamsValidationErrorReponse(Error error) {
        super(error);
    }
}
