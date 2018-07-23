package com.example.postgresdemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Mensaje {

    @NotEmpty(message = "El titulo del mensaje no debe estar vacio")
    private final String titulo;
    @NotEmpty(message = "El cuerpo del mensaje no debe estar vacio")
    private final String cuerpo;

    @JsonCreator
    public Mensaje(@JsonProperty("titulo") String titulo, @JsonProperty("cuerpo") String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cuerpo == null) ? 0 : cuerpo.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
        Mensaje other = (Mensaje) obj;
        if (cuerpo == null) {
            if (other.cuerpo != null)
                return false;
        } else if (!cuerpo.equals(other.cuerpo))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mensaje [titulo=" + titulo + ", cuerpo=" + cuerpo + ", toString()=" + super.toString() + "]";
    }

}
