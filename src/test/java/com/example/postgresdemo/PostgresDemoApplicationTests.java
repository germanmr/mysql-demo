package com.example.postgresdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.postgresdemo.model.Dispositivo;
import com.example.postgresdemo.model.DispositivoPK;
import com.example.postgresdemo.model.PrestadorPK;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresDemoApplicationTests {

    @Test
    public void contextLoads() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Short codigoprofesion = 4;

        Dispositivo dispositivo = new Dispositivo(new DispositivoPK("123123", new PrestadorPK(codigoprofesion, 64758)));

        System.out.println(objectMapper.writeValueAsString(dispositivo));

    }

}
