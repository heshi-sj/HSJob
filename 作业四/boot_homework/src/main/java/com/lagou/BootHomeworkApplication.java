package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BootHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootHomeworkApplication.class, args);
    }

}
