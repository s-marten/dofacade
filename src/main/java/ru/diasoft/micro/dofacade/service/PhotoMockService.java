package ru.diasoft.micro.dofacade.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dofacade.model.RecognitionResult;

@Service
@ConditionalOnProperty(
        value="photoService",
        havingValue = "mock",
        matchIfMissing = true
)
public class PhotoMockService implements IPhotoService {

    @Override
    public RecognitionResult comparePhotos(byte[] photo1, byte[] photo2) {
        return RecognitionResult.builder()
                .result(true)
                .percent(95.0)
                .build();
    }
}
