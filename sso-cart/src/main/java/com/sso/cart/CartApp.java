package com.sso.cart;

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
public class CartApp {
    public static void main(String[] args){
        SpringApplication.run(CartApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
