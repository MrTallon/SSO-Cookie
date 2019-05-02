package com.sso.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/05/01
 */
@SpringBootApplication
public class MainApp {
    public static void main(String[] args){
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
