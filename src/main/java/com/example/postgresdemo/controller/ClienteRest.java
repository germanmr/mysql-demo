package com.example.postgresdemo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.example.postgresdemo.model.MensajeDispositivos;
import com.example.postgresdemo.model.Respuesta;

public class ClienteRest {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private final String urlAmbiente;

    public ClienteRest() {

        final String environmentParameter = System.getenv("AMR_ENVIRONMENT");

        if (environmentParameter == null) {
            throw new IllegalStateException("No esta definida la variable de entorno AMR_ENVIRONMENT");
        }

        if (environmentParameter == "PRODUCCION") {
            urlAmbiente = "http://tomcat.amr.org.ar:8080/ClienteFCM/";
        } else {
            urlAmbiente = "http://tomcat-test.amr.org.ar:8080/ClienteFCM/";
        }

    }

    /**
     * Consumos el cliente FCM para enviar un mensaje a los dispositivos informados
     * @param mensajeDispositivos
     * @return
     */
    public Respuesta enviarMensajesPorId(MensajeDispositivos mensajeDispositivos) {

        String metodo = "mensajes/enviarMensajePorIds";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MensajeDispositivos> solicitud = new HttpEntity<MensajeDispositivos>(mensajeDispositivos, headers);

        URI uri;
        try {
            uri = new URI(urlAmbiente + metodo);
        } catch (Exception e) {
            return new Respuesta("ERROR", e.getMessage());
        }

        Respuesta respuesta = restTemplateBuilder.build().postForObject(uri, solicitud, Respuesta.class);

        return respuesta;

    }

}
