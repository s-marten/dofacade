package ru.diasoft.micro.dofacade.controller;

import java.io.IOException;
import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.micro.dofacade.dto.PhotoCompareReq;
import ru.diasoft.micro.dofacade.dto.PhotoCompareRes;
import ru.diasoft.micro.dofacade.dto.PhotoDescriptorsReq;
import ru.diasoft.micro.dofacade.dto.PhotoDescriptorsRes;
import ru.diasoft.micro.dofacade.dto.error.GenericErrorResponse;
import ru.diasoft.micro.dofacade.dto.error.InputParamsValidationErrorReponse;
import ru.diasoft.micro.dofacade.exception.RecognitionException;
import ru.diasoft.micro.dofacade.model.Error;
import ru.diasoft.micro.dofacade.service.PhotoService;

@RestController
@RequestMapping("api/v1/photo")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @ApiOperation(value = "Сравнение двух фотографий", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Операция завершилась успешно",
                    response = PhotoCompareRes.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Некорректные входящие параметры",
                    response = InputParamsValidationErrorReponse.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Внутренняя ошибка сервиса",
                    response = GenericErrorResponse.class
            )
    })
    @PostMapping("/compare")
    public ResponseEntity<PhotoCompareRes> comparePhotos(@Valid PhotoCompareReq req) {

        byte[] firstPhotoBytes;
        byte[] secondPhotoBytes;

        try {
            firstPhotoBytes = req.getFirstPhotoFile().getBytes();
        } catch (IOException e) {
            throw new RecognitionException(Error.COULDNT_DECODE, 1);
        }

        try {
            secondPhotoBytes = req.getSecondPhotoFile().getBytes();
        } catch (IOException e) {
            throw new RecognitionException(Error.COULDNT_DECODE, 2);
        }

        boolean comparisonResult = photoService.comparePhotos(firstPhotoBytes, secondPhotoBytes, req.getThreshold().doubleValue());
        PhotoCompareRes response = new PhotoCompareRes();
        response.setMatch(comparisonResult);

        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Получение списка дескрипторов для сохраненных фотографий.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Операция завершилась успешно",
                    response = PhotoDescriptorsRes.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Некорректные входящие параметры",
                    response = InputParamsValidationErrorReponse.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Внутренняя ошибка сервиса",
                    response = GenericErrorResponse.class
            )
    })
    @GetMapping("/descriptors")
    public ResponseEntity<PhotoDescriptorsRes> getDescriptors(@Valid PhotoDescriptorsReq req) {
        PhotoDescriptorsRes res = new PhotoDescriptorsRes();
        return ResponseEntity.ok(res);
    }
}
