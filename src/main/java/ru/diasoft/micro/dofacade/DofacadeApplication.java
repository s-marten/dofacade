package ru.diasoft.micro.dofacade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DofacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DofacadeApplication.class, args);
    }
}
