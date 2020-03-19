package ru.diasoft.micro.dofacade.service;

import ru.diasoft.micro.dofacade.exceptions.RecognitionException;
import ru.diasoft.micro.dofacade.model.RecognitionResult;

public interface IPhotoService {

    RecognitionResult comparePhotos(byte[] photo1, byte[] photo2) throws RecognitionException;
}
