package com.example.postgresdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.model.Dispositivo;
import com.example.postgresdemo.model.MensajeDispositivos;
import com.example.postgresdemo.model.MensajeEnviado;
import com.example.postgresdemo.model.PrestadorPK;
import com.example.postgresdemo.model.Respuesta;
import com.example.postgresdemo.repository.DispositivosRepository;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivosRepository repositorio;

    @Autowired
    private ClienteRest clienteRest;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/dispositivos")
    public List<Dispositivo> getDispositivos() {
        return repositorio.findAll();
    }

    @PostMapping("/dispositivos/lista")
    // public List<Dispositivo> getDispositivosByPrestadores(@RequestParam(name = "ids") List<PrestadorPK> ids) {
    public List<Dispositivo> getDispositivosByPrestadores(@RequestBody List<PrestadorPK> ids) {

        System.out.println(ids);

        return repositorio.findAllBydispositivoPKPrestadorPKIn(ids);

    }

    @GetMapping("/obtener/respuesta")
    public Respuesta obtenerRespuesta() {

        final String uri = "https://www.amr.org.ar/gestion/webServices/autorizador/test/ambulatorio/pruebaconectividad";

        System.out.println("Llamamos");

        Respuesta result = restTemplateBuilder.build().getForObject(uri, Respuesta.class);

        return result;

    }

    @GetMapping("/dispositivos/todos")
    public List<Dispositivo> getAllDispositivos() {
        // return repositorio.findByregistrationidIn(id);
        return repositorio.findAll();
    }

    @GetMapping("/devuelve")
    public Dispositivo devuelveEntidad() {

        Short codigoProfesion = 4;
        // return repositorio.findByregistrationidIn(id);
        // return new Dispositivo(new DispositivoPK("vklsdbhvlkdfb", new PrestadorPK(codigoProfesion, 456)));
        return null;

    }

    @PutMapping("/dispositivos/registrar")
    public Dispositivo registrarDispositivo(@RequestBody Dispositivo dispositivo) {

        System.out.println("Registramos: " + dispositivo);

        Dispositivo dispositivoInsertado = repositorio.save(dispositivo);

        return dispositivoInsertado;

    }

    @PostMapping("/enviar/mensaje")
    public Respuesta enviarMensaje(@RequestBody MensajeEnviado mensaje) {
        try {

            /**
             * Construimos mensaje
             */
            List<Dispositivo> dispositivos = repositorio.findAllBydispositivoPKPrestadorPKIn(mensaje.getPrestadores());

            List<String> dispositivosEnviados = new ArrayList<>();
            for (Dispositivo dispositivo : dispositivos) {
                dispositivosEnviados.add(dispositivo.getDispositivoPK().getRegistrationid());
            }

            if (dispositivos == null || dispositivos.size() == 0) {
                return new Respuesta("ERROR", "No hay dispositivos registrados para los prestadores informados");
            }

            Integer codigoProyecto = 1;
            MensajeDispositivos mensajeDispositivos = new MensajeDispositivos(mensaje.getMensaje(), dispositivosEnviados, codigoProyecto);
            /*****************************************************************************************/

            Respuesta respuesta = clienteRest.enviarMensajesPorId(mensajeDispositivos);

            if ("ERROR".equals(respuesta.getEstado())) {
                return new Respuesta("ERROR", respuesta.getMensaje());
            }

            /******************************************************************************************************/

            return new Respuesta("OK", "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Respuesta("ERROR", e.getMessage());

        }
    }

}
