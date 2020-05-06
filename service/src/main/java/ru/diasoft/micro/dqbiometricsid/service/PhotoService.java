package ru.diasoft.micro.dqbiometricsid.service;

import java.util.Optional;

import ru.diasoft.micro.dqbiometricsid.exception.RecognitionException;
import ru.diasoft.micro.dqbiometricsid.model.descriptor.Descriptor;

public interface PhotoService {

    boolean comparePhotos(byte[] photo1, byte[] photo2, double threshold) throws RecognitionException;
    Long savePhoto(byte[] photo);
    Optional<byte[]> getPhotoById(long id);

    Long saveDescriptor(long photoId, Descriptor descriptor);
}
