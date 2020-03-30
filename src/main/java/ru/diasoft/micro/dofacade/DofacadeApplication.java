package ru.diasoft.micro.dofacade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DofacadeApplication {

    static {
        try {
            System.loadLibrary("FaceVerifierJni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DofacadeApplication.class, args);
    }
}
