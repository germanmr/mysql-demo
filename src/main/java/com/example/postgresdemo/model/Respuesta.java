package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Respuesta {

    private final String estado;
    private final String mensaje;

    @JsonCreator
    public Respuesta(@JsonProperty("tiposRespuestaValidacion") String estado, @JsonProperty("mensaje") String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
        Respuesta other = (Respuesta) obj;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
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
        return "Respuesta [estado=" + estado + ", mensaje=" + mensaje + ", toString()=" + super.toString() + "]";
    }

}
