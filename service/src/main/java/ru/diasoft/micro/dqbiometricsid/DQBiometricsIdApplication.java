package ru.diasoft.micro.dqbiometricsid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DQBiometricsIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(DQBiometricsIdApplication.class, args);
    }
}
