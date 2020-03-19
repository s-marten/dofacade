package ru.diasoft.micro.dofacade.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.diasoft.micro.dofacade.exceptions.RecognitionException;
import ru.diasoft.micro.dofacade.model.ErrorCases;
import ru.diasoft.micro.dofacade.model.RecognitionErrorResponse;
import ru.diasoft.micro.dofacade.model.RecognitionResult;
import ru.diasoft.micro.dofacade.service.IPhotoService;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhotoControllerTest {

    @Mock
    private IPhotoService photoService;

    private PhotoController controller;

    private MultipartFile photo1 = new MockMultipartFile("data", "photo1.jpg", "file", "photo1".getBytes());
    private MultipartFile photo2 = new MockMultipartFile("data", "photo1.jpg", "file", "photo2".getBytes());


    @Before
    public void setUp() {
        controller = new PhotoController(photoService);
    }

    @Test
    public void comparePhotos() throws IOException, RecognitionException {

        RecognitionResult result = RecognitionResult.builder()
                .percent(95.0)
                .result(true)
                .build();

        when(photoService.comparePhotos(photo1.getBytes(), photo2.getBytes())).thenReturn(result);

        ResponseEntity<?> answer = controller.comparePhotos(photo1, photo2);

        assertEquals(HttpStatus.OK, answer.getStatusCode());
        RecognitionResult body = (RecognitionResult) answer.getBody();
        assertEquals(result, body);
    }

    @Test
    public void comparePhotosWithDecodingErrorInPhoto1() throws IOException {

        //TODO: А может ли заставить MockMultipart кинуть IOExcpetion?
        MultipartFile photoWithoutContent = Mockito.mock(MultipartFile.class);

        when(photoWithoutContent.getBytes()).thenThrow(new IOException());

        ResponseEntity<?> answer = controller.comparePhotos(photoWithoutContent, photo2);

        assertEquals(400, answer.getStatusCodeValue());
        RecognitionErrorResponse body = (RecognitionErrorResponse) answer.getBody();
        RecognitionErrorResponse expectedBody = new RecognitionErrorResponse(ErrorCases.COULDNT_DECODE, 1);
        assertEquals(expectedBody, body);
    }

    @Test
    public void comparePhotosWithDecodingErrorInPhoto2() throws IOException {

        //TODO: А может ли заставить MockMultipart кинуть IOExcpetion?
        MultipartFile photoWithoutContent = Mockito.mock(MultipartFile.class);

        when(photoWithoutContent.getBytes()).thenThrow(new IOException());

        ResponseEntity<?> answer = controller.comparePhotos(photo1, photoWithoutContent);

        assertEquals(400, answer.getStatusCodeValue());
        RecognitionErrorResponse body = (RecognitionErrorResponse) answer.getBody();
        RecognitionErrorResponse expectedBody = new RecognitionErrorResponse(ErrorCases.COULDNT_DECODE, 2);
        assertEquals(expectedBody, body);
    }

    @Test
    public void comparePhotosWithRecognitionError() throws IOException, RecognitionException {

        RecognitionException exception = RecognitionException.builder()
                .photoId(1)
                .sdkErrorText("Sdk error")
                .build();

        when(photoService.comparePhotos(photo1.getBytes(), photo2.getBytes())).thenThrow(exception);

        ResponseEntity<?> answer = controller.comparePhotos(photo1, photo2);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, answer.getStatusCode());

        RecognitionErrorResponse expectedErrorBody = new RecognitionErrorResponse(ErrorCases.UNEXPECTED_RECOGNITION_ERROR, 1);

        assertEquals(expectedErrorBody, answer.getBody());
    }
}