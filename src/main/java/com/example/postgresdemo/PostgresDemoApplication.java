package com.example.postgresdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import com.example.postgresdemo.controller.ClienteRest;
import com.example.postgresdemo.filtros.JwtFilter;

@SpringBootApplication
@EnableJpaAuditing
public class PostgresDemoApplication extends SpringBootServletInitializer {

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

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
