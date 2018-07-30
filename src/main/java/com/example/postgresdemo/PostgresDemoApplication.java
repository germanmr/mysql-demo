package com.example.postgresdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import com.example.postgresdemo.controller.ClienteRest;

// scanBasePackages={"com.example.something", "com.example.application"}

@SpringBootApplication(scanBasePackages = {"com.example.postgresdemo"})
@ComponentScan({"com.example.postgresdemo.controller"})
@EntityScan("com.example.postgresdemo")
// @EnableJpaRepositories("com.example.postgresdemo")
@EnableJpaAuditing
public class PostgresDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresDemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ClienteRest getClienteRest() {
        return new ClienteRest();
    }
}
