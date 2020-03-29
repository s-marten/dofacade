package ru.diasoft.micro.dofacade.domain.faceverifier;

import org.springframework.stereotype.Component;

@Component
public class FaceVerifierJni {

    public native boolean verify(String path1, String path2, double threshhold);
}
