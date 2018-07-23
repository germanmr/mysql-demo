package com.example.postgresdemo.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MensajeEnviado {

    @NotNull(message = "El mensaje no puede estar vacio")
    @Valid
    private final Mensaje mensaje;
    @NotEmpty(message = "Debe informar al menos un prestador")
    private final List<PrestadorPK> prestadores;

    @JsonCreator
    public MensajeEnviado(@JsonProperty("mensaje") Mensaje mensaje, @JsonProperty("prestadores") List<PrestadorPK> prestadores) {
        this.mensaje = mensaje;
        this.prestadores = prestadores;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public List<PrestadorPK> getPrestadores() {
        return prestadores;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
        result = prime * result + ((prestadores == null) ? 0 : prestadores.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MensajeEnviado other = (MensajeEnviado) obj;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        if (prestadores == null) {
            if (other.prestadores != null)
                return false;
        } else if (!prestadores.equals(other.prestadores))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MensajeEnviado [mensaje=" + mensaje + ", prestadores=" + prestadores + ", toString()=" + super.toString() + "]";
    }

}
