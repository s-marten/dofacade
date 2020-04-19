package ru.diasoft.micro.dofacade.dto.error;

import java.util.List;
import java.util.Objects;

import ru.diasoft.micro.dofacade.model.Error;

public class InputParamsValidationErrorReponse extends GenericErrorResponse {

    private List<String> inputParamErrors;

    public InputParamsValidationErrorReponse(Error error) {
        super(error);
    }

    public List<String> getInputParamErrors() {
        return List.copyOf(Objects.requireNonNullElse(inputParamErrors, List.of()));
    }

    public void setInputParamErrors(List<String> inputParamErrors) {
        this.inputParamErrors = inputParamErrors;
    }
}
