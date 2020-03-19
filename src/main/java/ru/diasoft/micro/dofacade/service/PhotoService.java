package ru.diasoft.micro.dofacade.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dofacade.model.RecognitionResult;

//TODO: Сюда подрубать реальные апихи
@Service
@ConditionalOnProperty(
        value="photoService",
        havingValue = "ntechlab"
)
public class PhotoService implements IPhotoService {

    @Override
    public RecognitionResult comparePhotos(byte[] photo1, byte[] photo2) {
        return null;
    }
}
