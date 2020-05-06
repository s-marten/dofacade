package ru.diasoft.micro.dqbiometricsid.domain.faceverifier;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name="photoService",
        havingValue = "ntechlab"
)
public class FaceVerifierJni {

    private static final Logger LOGGER = LoggerFactory.getLogger(FaceVerifierJni.class);

    @PostConstruct
    private void init() {
        try {
            System.loadLibrary("FaceVerifierJni");
        } catch (UnsatisfiedLinkError e) {
            LOGGER.error("Native code library failed to load.", e);
            System.exit(1);
        }
    }

    public native boolean verify(String path1, String path2, double threshhold);
}
