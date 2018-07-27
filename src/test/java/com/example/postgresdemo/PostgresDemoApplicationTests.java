package com.example.postgresdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.postgresdemo.model.Dispositivo;
import com.example.postgresdemo.model.DispositivoPK;
import com.example.postgresdemo.model.Mensaje;
import com.example.postgresdemo.model.MensajeEnviado;
import com.example.postgresdemo.model.PrestadorPK;
import com.example.postgresdemo.model.Respuesta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresDemoApplicationTests {

    @Autowired

    @Test
    public void contextLoads() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Short codigoprofesion = 4;

        Dispositivo dispositivo = new Dispositivo(new DispositivoPK("123123", new PrestadorPK(codigoprofesion, 64758)));

        System.out.println(objectMapper.writeValueAsString(dispositivo));

    }

    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<PrestadorPK> prestadores = new ArrayList<>();

        Short codigoprofesion = 4;
        prestadores.add(new PrestadorPK(codigoprofesion, 4275));
        MensajeEnviado mensaje = new MensajeEnviado(new Mensaje("titulo", "cuerpo"), prestadores);

        System.out.println(objectMapper.writeValueAsString(mensaje));
    }

    @Test
    public void testEnviar() {

        // List<String> dispositivosEnviados = new ArrayList<>();
        // for (Dispositivo dispositivo : dispositivos) {
        // dispositivosEnviados.add(dispositivo.getDispositivoPK().getRegistrationid());
        // }
        //
        // if (dispositivos == null || dispositivos.size() == 0) {
        // return new Respuesta("ERROR", "No hay dispositivos registrados para los prestadores informados");
        // }
        //
        // // String entidadJson = objec.convertToJSON(new MensajeDispositivos(mensajeEnviado.getMensaje(),
        // // dispositivos, 1));
        // String entidadJson = "";
        //
        // // RespuestaBase respuestaBase = clienteFCM.enviarMensaje(entidadJson);
        //
        // final String uri = "http://tomcat-test.amr.org.ar:8080/ClienteFCM/mensajes/enviarMensajePorIds";
        //
        // System.out.println("Llamamos");
        //
        // Map<String, String> parametro = new HashMap<>();
        //
        // String mensajeJson = objectMapper.writeValueAsString(mensaje);
        //
        // // parametro.put("", mensajeJson);
        // // Respuesta result = restTemplateBuilder.build().postForObject(uri, mensaje, Respuesta.class);
        // //
        // // System.out.println(result);
        //
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        //
        // MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        // map.add("", mensajeJson);
        //
        // HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
        // headers);
        //
        // // ResponseEntity<Respuesta> response = restTemplateBuilder.build().postForEntity(uri, request,
        // // Respuesta.class);
        //
        // headers.setContentType(MediaType.APPLICATION_JSON);
        //
        // HttpEntity<MensajeEnviado> solicitud = new HttpEntity<MensajeEnviado>(mensaje, headers);
        //
        // Respuesta response = restTemplateBuilder.build().postForObject(uri, solicitud, Respuesta.class);
        //
        // System.out.println(response);
        //
        // return new Respuesta("OK", "");
    }

}
