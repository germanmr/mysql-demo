package com.example.postgresdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.model.Dispositivo;
import com.example.postgresdemo.model.PrestadorPK;
import com.example.postgresdemo.repository.DispositivosRepository;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivosRepository repositorio;

    @GetMapping("/dispositivos")
    public List<Dispositivo> getDispositivos() {
        return repositorio.findAll();
    }

    @GetMapping("/dipositivos/lista")
    public List<Dispositivo> getDispositivosByLista(@RequestParam(name = "id") List<String> id) {
        return repositorio.findByregistrationidIn(id);
    }

    @PutMapping("/dispositivos/registrar")
    public Dispositivo registrarDispositivo(@RequestParam("codigoProfesion") final Integer codigoProfesion,
        @RequestParam("matricula") final Integer matricula, @RequestParam("registrationId") String registrationId) {

        Long claveCandidata = (long) 0;

        // return repositorio.save(new Dispositivo(claveCandidata, registrationId, new PrestadorPK(codigoProfesion,
        // matricula)));

        Dispositivo dispositivo = new Dispositivo(claveCandidata, "123456", new PrestadorPK(4, 64758));

        System.out.println("Registramos: " + dispositivo);

        return repositorio.save(dispositivo);

    }

}
