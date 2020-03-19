package ru.diasoft.micro.dofacade.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dofacade.model.RecognitionResult;

import javax.annotation.PostConstruct;

//TODO: Сюда подрубать реальные апихи
@Service
@ConditionalOnProperty(
        value="photoService",
        havingValue = "ntechlab"
)
@Slf4j
public class PhotoService implements IPhotoService {

    @PostConstruct
    private void logAfterInit() {
        log.info("Started NTechLab Photo service");
    }

    @Override
    public RecognitionResult comparePhotos(byte[] photo1, byte[] photo2) {
        return null;
    }
}
