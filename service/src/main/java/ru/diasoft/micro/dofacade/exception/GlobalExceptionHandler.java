package ru.diasoft.micro.dofacade.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.diasoft.micro.dofacade.dto.error.GenericErrorResponse;
import ru.diasoft.micro.dofacade.dto.error.InputParamsValidationErrorReponse;
import ru.diasoft.micro.dofacade.dto.error.RecognitionErrorResponse;
import ru.diasoft.micro.dofacade.model.Error;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericErrorResponse> handleGenericException(GenericException e) {
        log.warn("Generic error", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericErrorResponse(e.getError()));
    }

    @ExceptionHandler(RecognitionException.class)
    public ResponseEntity<RecognitionErrorResponse> handleRecognitionException(RecognitionException e) {
        log.warn("Recognition error", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RecognitionErrorResponse(e.getError(), e.getPhotoId()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<InputParamsValidationErrorReponse> handleBindException(BindException e) {
        log.warn("Validation error", e);
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            String error = String.format("[%s] %s", fieldError.getField(), fieldError.getDefaultMessage());
            errors.add(error);
        }

        InputParamsValidationErrorReponse response = new InputParamsValidationErrorReponse(Error.INPUT_PARAMS_VALIDATION_ERROR);
        response.setInputParamErrors(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
