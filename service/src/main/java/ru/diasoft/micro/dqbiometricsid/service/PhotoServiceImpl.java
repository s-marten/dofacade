package ru.diasoft.micro.dqbiometricsid.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.micro.dqbiometricsid.converter.DescriptorToDbEntityConverter;
import ru.diasoft.micro.dqbiometricsid.domain.faceverifier.FaceVerifierJni;
import ru.diasoft.micro.dqbiometricsid.exception.GenericException;
import ru.diasoft.micro.dqbiometricsid.model.Error;
import ru.diasoft.micro.dqbiometricsid.model.descriptor.Descriptor;
import ru.diasoft.micro.dqbiometricsid.model.entity.DescriptorEntity;
import ru.diasoft.micro.dqbiometricsid.model.entity.PhotoEntity;
import ru.diasoft.micro.dqbiometricsid.repository.DescriptorRepository;
import ru.diasoft.micro.dqbiometricsid.repository.PhotoRepository;

@Service
@ConditionalOnProperty(
        name = "photoService",
        havingValue = "ntechlab"
)
public class PhotoServiceImpl implements PhotoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServiceImpl.class);

    private static final String IMG_FORMAT = "png";

    private final FaceVerifierJni faceVerifierJni;
    private final PhotoRepository photoRepository;
    private final DescriptorRepository descriptorRepository;

    @Autowired
    public PhotoServiceImpl(
            FaceVerifierJni faceVerifierJni,
            PhotoRepository photoRepository,
            DescriptorRepository descriptorRepository) {
        this.faceVerifierJni = faceVerifierJni;
        this.photoRepository = photoRepository;
        this.descriptorRepository = descriptorRepository;
    }

    @PostConstruct
    private void logAfterInit() {
        LOGGER.info("Started NTechLab Photo service");
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

    @Override
    @Transactional
    public Long savePhoto(byte[] photo) {
        PhotoEntity entity = new PhotoEntity();
        entity.setImg(photo);
        entity = photoRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Optional<byte[]> getPhotoById(long id) {
        return photoRepository.findById(id).map(PhotoEntity::getImg);
    }

    @Override
    @Transactional
    public Long saveDescriptor(long photoId, Descriptor descriptor) {
        DescriptorEntity entity = new DescriptorToDbEntityConverter().createFrom(descriptor);
        entity.setPhotoId(photoId);
        entity = descriptorRepository.save(entity);
        return entity.getId();
    }

    private Path createTempImage(byte[] byteArray) {
        Path path;
        try (ByteArrayInputStream is = new ByteArrayInputStream(byteArray)) {
            path = Files.createTempFile(null, "." + IMG_FORMAT);
            BufferedImage bufferedImage = ImageIO.read(is);
            ImageIO.write(bufferedImage, IMG_FORMAT, path.toFile());
        } catch (IOException e) {
            LOGGER.error("Couldn't create temp file", e);
            throw new GenericException(Error.INTERNAL);
        }
        return path;
    }

    private void deleteTempImage(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            LOGGER.warn("Couldn't delete temp file", e);
        }
    }
}
