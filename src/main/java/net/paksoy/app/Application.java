package net.paksoy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="net.paksoy")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
