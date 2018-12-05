package com.example.postgresdemo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.postgresdemo.model.Dispositivo;
import com.example.postgresdemo.model.Persona;

@RestController
public class PersonaController {

    // @Autowired
    // private PersonaRepository PersonaRepository;

    @GetMapping("/personas")
    public List<Persona> obtenerAllPersonas() {
        // return personaRepository.findAll();
        return null;
    }

    @GetMapping("/personas/{id}")
    public Persona obtenerPersona(@PathVariable long id) {
        // Optional<Persona> Persona = personaRepository.findById(id);
        //
        // if (!Persona.isPresent())
        // throw new PersonaNotFoundException("id-" + id);
        //
        // return Persona.get();
        return null;
    }

    @DeleteMapping("/personas/{id}")
    public void deletePersona(@PathVariable long id) {
        // personaRepository.deleteById(id);
    }

    @PostMapping("/personas")
    public ResponseEntity<Object> registrarPersona(@RequestBody Persona Persona) {
        Persona savedPersona = personaRepository.save(Persona);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPersona.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/personas/registrar")
    public Dispositivo registrarDispositivo(@RequestBody Persona dispositivo) {
        // public ResponseEntity<Object> createPersona(@RequestBody Persona Persona) {

        Persona savedPersona = personaRepository.save(Persona);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPersona.getId()).toUri();

        // return ResponseEntity.created(location).build();

        System.out.println("Registramos: " + dispositivo);

        Dispositivo dispositivoInsertado = repositorio.save(dispositivo);

        return dispositivoInsertado;

    }

    @PutMapping("/Personas/{id}")
    public ResponseEntity<Object> updatePersona(@RequestBody Persona Persona, @PathVariable long id) {

        Optional<Persona> PersonaOptional = personaRepository.findById(id);

        if (!PersonaOptional.isPresent())
            return ResponseEntity.notFound().build();

        Persona.setId(id);

        PersonaRepository.save(Persona);

        return ResponseEntity.noContent().build();
    }
}
