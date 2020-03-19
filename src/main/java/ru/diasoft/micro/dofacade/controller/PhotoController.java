package ru.diasoft.micro.dofacade.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.diasoft.micro.dofacade.exceptions.RecognitionException;
import ru.diasoft.micro.dofacade.model.ErrorCases;
import ru.diasoft.micro.dofacade.model.RecognitionErrorResponse;
import ru.diasoft.micro.dofacade.model.RecognitionResult;
import ru.diasoft.micro.dofacade.service.IPhotoService;

import java.io.IOException;

@RestController
@RequestMapping("/photoRecognition")
@RequiredArgsConstructor
public class PhotoController {

    private final IPhotoService photoService;

    @ApiOperation(value = "Сравнение двух фоток", response = RecognitionResult.class)
    @PostMapping("/comparePhotos")
    public ResponseEntity<?> comparePhotos(MultipartFile photo1, MultipartFile photo2) {

        byte[] photo1Bytes;
        byte[] photo2Bytes;

        try {
            photo1Bytes = photo1.getBytes();
        } catch (IOException e) {
            return ResponseEntity.status(400).body(new RecognitionErrorResponse(ErrorCases.COULDNT_DECODE, 1));
        }

        try {
            photo2Bytes = photo2.getBytes();
        } catch (IOException e) {
            return ResponseEntity.status(400).body(new RecognitionErrorResponse(ErrorCases.COULDNT_DECODE, 2));
        }

        RecognitionResult result;
        try {
            result = photoService.comparePhotos(photo1Bytes, photo2Bytes);
        } catch (RecognitionException e) {
            //TODO: Скорее всего нужно будет развести и отдавать 400ку или 200ку, если на фотке нет лиц, например
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new RecognitionErrorResponse(ErrorCases.UNEXPECTED_RECOGNITION_ERROR, e.getPhotoId())
            );
        }

        assert result != null;
        return ResponseEntity.ok(result);
    }
}
