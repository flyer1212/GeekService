package com.geek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@EnableAsync
public class GeekApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeekApplication.class);
    }
}
