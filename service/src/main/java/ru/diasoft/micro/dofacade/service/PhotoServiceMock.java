package ru.diasoft.micro.dofacade.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="photoService",
        havingValue = "mock",
        matchIfMissing = true
)
public class PhotoServiceMock implements PhotoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServiceMock.class);

    @PostConstruct
    private void logAfterInit() {
        LOGGER.info("Started Photo Mock Service");
    }

    @Override
    public boolean comparePhotos(byte[] photo1, byte[] photo2, double threshold) {
        return true;
    }
}
