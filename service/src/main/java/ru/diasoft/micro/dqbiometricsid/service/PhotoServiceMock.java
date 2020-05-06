package ru.diasoft.micro.dqbiometricsid.service;

import java.util.Optional;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dqbiometricsid.model.descriptor.Descriptor;

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

    @Override
    public Long savePhoto(byte[] photo) {
        return null;
    }

    @Override
    public Optional<byte[]> getPhotoById(long id) {
        return Optional.empty();
    }

    @Override
    public Long saveDescriptor(long photoId, Descriptor descriptor) {
        return null;
    }
}
