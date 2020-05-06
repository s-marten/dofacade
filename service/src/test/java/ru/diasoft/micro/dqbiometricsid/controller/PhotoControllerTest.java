package ru.diasoft.micro.dqbiometricsid.controller;

import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PhotoControllerTest {

    private static final String THRESHOLD = "0.75";

    @Autowired
    private MockMvc mockMvc;

    private static MockMultipartFile firstPhotoMock = new MockMultipartFile("firstPhotoFile", new byte[0]);
    private static MockMultipartFile secondPhotoMock = new MockMultipartFile("secondPhotoFile", new byte[0]);
    private static MockMultipartFile nullFile = new MockMultipartFile("file", (byte[]) null);

    private ResultActions performComparePhotosRequest(MockMultipartFile firstPhoto, MockMultipartFile secondPhoto, String threshold) throws Exception {
        return mockMvc.perform(multipart("/api/v1/photo/compare").file(firstPhoto).file(secondPhoto).param("threshold", threshold));
    }

    @ParameterizedTest
    @MethodSource("provideWrongParametersForComparePhotos")
    public void comparePhotos_noImageFiles(MockMultipartFile firstPhoto, MockMultipartFile secondPhoto, String threshold, int errorsCount) throws Exception {
        performComparePhotosRequest(firstPhoto, secondPhoto, threshold)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.inputParamErrors", Matchers.hasSize(errorsCount)));
    }

    private static Stream<Arguments> provideWrongParametersForComparePhotos() {
        return Stream.of(
                Arguments.of(nullFile, nullFile, THRESHOLD, 2),
                Arguments.of(firstPhotoMock, nullFile, THRESHOLD, 1),
                Arguments.of(nullFile, secondPhotoMock, THRESHOLD, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWrongThresholdForComparePhotos")
    void comparePhotos_wrongThreshold(MockMultipartFile firstPhoto, MockMultipartFile secondPhoto, String threshold) throws Exception {
        performComparePhotosRequest(firstPhoto, secondPhoto, threshold)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.inputParamErrors", Matchers.hasSize(1)));
    }

    private static Stream<Arguments> provideWrongThresholdForComparePhotos() {
        return Stream.of(
                Arguments.of(firstPhotoMock, secondPhotoMock, null),
                Arguments.of(firstPhotoMock, secondPhotoMock, "-3"),
                Arguments.of(firstPhotoMock, secondPhotoMock, "-0.7"),
                Arguments.of(firstPhotoMock, secondPhotoMock, "4"),
                Arguments.of(firstPhotoMock, secondPhotoMock, "1.1")
        );
    }

    @Test
    void comparePhotos_shouldReturnSuccess() throws Exception {
        performComparePhotosRequest(firstPhotoMock, secondPhotoMock, THRESHOLD)
                .andDo(print())
                .andExpect(status().isOk());
    }
}
