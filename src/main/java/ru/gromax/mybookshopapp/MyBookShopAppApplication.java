package ru.gromax.mybookshopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class MyBookShopAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBookShopAppApplication.class, args);
    }

}
