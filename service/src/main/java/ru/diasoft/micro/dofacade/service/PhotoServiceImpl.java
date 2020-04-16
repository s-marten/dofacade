package ru.diasoft.micro.dofacade.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dofacade.domain.faceverifier.FaceVerifierJni;
import ru.diasoft.micro.dofacade.exception.GenericException;
import ru.diasoft.micro.dofacade.model.Error;

@Service
@ConditionalOnProperty(
        name="photoService",
        havingValue = "ntechlab"
)
@AllArgsConstructor
@Slf4j
public class PhotoServiceImpl implements PhotoService {

    private static final String IMG_FORMAT = "png";

    private final FaceVerifierJni faceVerifierJni;

    @PostConstruct
    private void logAfterInit() {
        log.info("Started NTechLab Photo service");
    }

    @Override
    public boolean comparePhotos(byte[] firstPhoto, byte[] secondPhoto, double threshold) {
        Path firstPhotoTempFilePath = createTempImage(firstPhoto);
        Path secondPhotoTempFilePath = createTempImage(secondPhoto);

        boolean verificationResult = faceVerifierJni.verify(firstPhotoTempFilePath.toString(), secondPhotoTempFilePath.toString(), threshold);

        deleteTempImage(firstPhotoTempFilePath);
        deleteTempImage(secondPhotoTempFilePath);

        return verificationResult;
    }

    private Path createTempImage(byte[] byteArray) {
        Path path;
        try (ByteArrayInputStream is = new ByteArrayInputStream(byteArray)) {
            path = Files.createTempFile(null, "." + IMG_FORMAT);
            BufferedImage bufferedImage = ImageIO.read(is);
            ImageIO.write(bufferedImage, IMG_FORMAT, path.toFile());
        } catch (IOException e) {
            log.error("Couldn't create temp file", e);
            throw new GenericException(Error.INTERNAL);
        }
        return path;
    }

    private void deleteTempImage(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            log.warn("Couldn't delete temp file", e);
        }
    }
}
