package com.demo.testvone.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class})
public class DemoTestvoneWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestvoneWorkApplication.class, args);
    }
}
