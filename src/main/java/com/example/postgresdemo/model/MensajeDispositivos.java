package com.example.postgresdemo.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MensajeDispositivos {

    @NotNull(message = "Debe informar el mensaje a enviar")
    @Valid
    private final Mensaje mensaje;
    @NotEmpty(message = "Debe informar al menos un id de dispositivo")
    private final List<String> dispositivos;
    @NotNull(message = "El codigo de proyecto no puede estar vacio")
    private final Integer codigoProyecto;

    @JsonCreator
    public MensajeDispositivos(@JsonProperty("mensaje") Mensaje mensaje, @JsonProperty("dispositivos") List<String> dispositivos,
        @JsonProperty("codigoProyecto") Integer codigoProyecto) {
        this.mensaje = mensaje;
        this.dispositivos = dispositivos;
        this.codigoProyecto = codigoProyecto;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public List<String> getDispositivos() {
        return dispositivos;
    }

    public Integer getCodigoProyecto() {
        return codigoProyecto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoProyecto == null) ? 0 : codigoProyecto.hashCode());
        result = prime * result + ((dispositivos == null) ? 0 : dispositivos.hashCode());
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
        MensajeDispositivos other = (MensajeDispositivos) obj;
        if (codigoProyecto == null) {
            if (other.codigoProyecto != null)
                return false;
        } else if (!codigoProyecto.equals(other.codigoProyecto))
            return false;
        if (dispositivos == null) {
            if (other.dispositivos != null)
                return false;
        } else if (!dispositivos.equals(other.dispositivos))
            return false;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MensajeDispositivos [mensaje=" + mensaje + ", dispositivos=" + dispositivos + ", codigoProyecto=" + codigoProyecto
            + ", toString()=" + super.toString() + "]";
    }

}
