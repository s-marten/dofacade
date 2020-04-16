package ru.diasoft.micro.dofacade.service;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="photoService",
        havingValue = "mock",
        matchIfMissing = true
)
@Slf4j
public class PhotoServiceMock implements PhotoService {

    @PostConstruct
    private void logAfterInit() {
        log.info("Started Photo Mock Service");
    }

    @Override
    public boolean comparePhotos(byte[] photo1, byte[] photo2, double threshold) {
        return true;
    }
}
