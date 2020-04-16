package ru.diasoft.micro.dofacade.domain.faceverifier;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name="photoService",
        havingValue = "ntechlab"
)
@Slf4j
public class FaceVerifierJni {

    @PostConstruct
    private void init() {
        try {
            System.loadLibrary("FaceVerifierJni");
        } catch (UnsatisfiedLinkError e) {
            log.error("Native code library failed to load.", e);
            System.exit(1);
        }
    }

    public native boolean verify(String path1, String path2, double threshhold);
}
