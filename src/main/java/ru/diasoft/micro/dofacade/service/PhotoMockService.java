package ru.diasoft.micro.dofacade.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dofacade.model.RecognitionResult;

import javax.annotation.PostConstruct;

@Service
@ConditionalOnProperty(
        value="photoService",
        havingValue = "mock",
        matchIfMissing = true
)
@Slf4j
public class PhotoMockService implements IPhotoService {

    @PostConstruct
    private void logAfterInit() {
        log.info("Started Photo Mock Service");
    }

    @Override
    public RecognitionResult comparePhotos(byte[] photo1, byte[] photo2) {
        return RecognitionResult.builder()
                .result(true)
                .percent(95.0)
                .build();
    }
}
