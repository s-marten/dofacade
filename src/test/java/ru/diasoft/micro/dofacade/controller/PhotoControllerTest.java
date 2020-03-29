package ru.diasoft.micro.dofacade.controller;

import java.io.IOException;
import java.math.BigDecimal;

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
import ru.diasoft.micro.dofacade.dto.ComparePhotosReq;
import ru.diasoft.micro.dofacade.dto.error.RecognitionErrorResponse;
import ru.diasoft.micro.dofacade.exception.RecognitionException;
import ru.diasoft.micro.dofacade.model.Error;
import ru.diasoft.micro.dofacade.service.PhotoServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhotoControllerTest {

    private static final String THRESHOLD = "0.95";

    @Mock
    private PhotoServiceImpl photoService;

    private PhotoController controller;

    private MultipartFile photo1 = new MockMultipartFile("data", "photo1.jpg", "file", "photo1".getBytes());
    private MultipartFile photo2 = new MockMultipartFile("data", "photo1.jpg", "file", "photo2".getBytes());


    @Before
    public void setUp() {
        controller = new PhotoController(photoService);
    }

    @Test
    public void comparePhotos() throws IOException, RecognitionException {

        when(photoService.comparePhotos(photo1.getBytes(), photo2.getBytes(), 0.7)).thenReturn(true);

        ComparePhotosReq req = new ComparePhotosReq();
        req.setFirstPhotoFile(photo1);
        req.setSecondPhotoFile(photo2);
        req.setThreshold(new BigDecimal(THRESHOLD));
        ResponseEntity<?> answer = controller.comparePhotos(req);

        assertEquals(HttpStatus.OK, answer.getStatusCode());
        /*RecognitionResult body = (RecognitionResult) answer.getBody();
        assertTrue(body.getResult());*/
    }

    @Test
    public void comparePhotosWithDecodingErrorInPhoto1() throws IOException {

        //TODO: А может ли заставить MockMultipart кинуть IOExcpetion?
        MultipartFile photoWithoutContent = Mockito.mock(MultipartFile.class);

        when(photoWithoutContent.getBytes()).thenThrow(new IOException());

        ComparePhotosReq req = new ComparePhotosReq();
        req.setFirstPhotoFile(photoWithoutContent);
        req.setSecondPhotoFile(photo2);
        req.setThreshold(new BigDecimal(THRESHOLD));
        ResponseEntity<?> answer = controller.comparePhotos(req);

        assertEquals(400, answer.getStatusCodeValue());
        RecognitionErrorResponse body = (RecognitionErrorResponse) answer.getBody();
        RecognitionErrorResponse expectedBody = new RecognitionErrorResponse(Error.COULDNT_DECODE, 1);
        assertEquals(expectedBody, body);
    }

    @Test
    public void comparePhotosWithDecodingErrorInPhoto2() throws IOException {

        //TODO: А может ли заставить MockMultipart кинуть IOExcpetion?
        MultipartFile photoWithoutContent = Mockito.mock(MultipartFile.class);

        when(photoWithoutContent.getBytes()).thenThrow(new IOException());

        ComparePhotosReq req = new ComparePhotosReq();
        req.setFirstPhotoFile(photo1);
        req.setSecondPhotoFile(photoWithoutContent);
        req.setThreshold(new BigDecimal(THRESHOLD));
        ResponseEntity<?> answer = controller.comparePhotos(req);

        assertEquals(400, answer.getStatusCodeValue());
        RecognitionErrorResponse body = (RecognitionErrorResponse) answer.getBody();
        RecognitionErrorResponse expectedBody = new RecognitionErrorResponse(Error.COULDNT_DECODE, 2);
        assertEquals(expectedBody, body);
    }

    /*@Test
    public void comparePhotosWithRecognitionError() throws IOException, RecognitionException {

        RecognitionException exception = RecognitionException.builder()
                .photoId(1)
                .message("Sdk error")
                .build();

        when(photoService.comparePhotos(photo1.getBytes(), photo2.getBytes())).thenThrow(exception);

        ResponseEntity<?> answer = controller.comparePhotos(photo1, photo2);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, answer.getStatusCode());

        RecognitionError expectedErrorBody = new RecognitionError(Error.UNEXPECTED_RECOGNITION_ERROR, 1);

        assertEquals(expectedErrorBody, answer.getBody());
    }*/
}