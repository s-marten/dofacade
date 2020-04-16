package ru.diasoft.micro.dofacade.service;

import ru.diasoft.micro.dofacade.exception.RecognitionException;

public interface PhotoService {

    boolean comparePhotos(byte[] photo1, byte[] photo2, double threshold) throws RecognitionException;
}
