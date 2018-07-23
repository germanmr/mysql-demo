package com.example.postgresdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clave primaria de un {@link Prestador}
 * @author Fabricio Pizzichillo fpizzichillo
 */
@Embeddable
@Entity(name = "PrestadorPKEmbebible")
public class PrestadorPKEmbebible implements Serializable {

    @Id
    @Column(name = "codigoprofesion")
    private Integer codigoprofesion;

    @Id
    @Column(name = "matriculaprofesional")
    private Integer matriculaprofesional;

    public PrestadorPKEmbebible() {
    }

    /**
     * Crea una instancia con los parámetros requeridos
     * @param codigoprofesion
     * @param matricula
     * @param libro
     * @param folio
     */
    @JsonCreator
    public PrestadorPKEmbebible(@JsonProperty("codigoProfesion") Integer codigoprofesion, @JsonProperty("matricula") Integer matricula) {
        this.codigoprofesion = codigoprofesion;
        this.matriculaprofesional = matricula;
    }

    public Integer getCodigoprofesion() {
        return codigoprofesion;
    }

    public void setCodigoprofesion(Integer codigoprofesion) {
        this.codigoprofesion = codigoprofesion;
    }

    public Integer getMatriculaprofesional() {
        return matriculaprofesional;
    }

    public void setMatriculaprofesional(Integer matriculaprofesional) {
        this.matriculaprofesional = matriculaprofesional;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoprofesion == null) ? 0 : codigoprofesion.hashCode());
        result = prime * result + ((matriculaprofesional == null) ? 0 : matriculaprofesional.hashCode());
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
        PrestadorPKEmbebible other = (PrestadorPKEmbebible) obj;
        if (codigoprofesion == null) {
            if (other.codigoprofesion != null)
                return false;
        } else if (!codigoprofesion.equals(other.codigoprofesion))
            return false;
        if (matriculaprofesional == null) {
            if (other.matriculaprofesional != null)
                return false;
        } else if (!matriculaprofesional.equals(other.matriculaprofesional))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PrestadorPK [codigoprofesion=" + codigoprofesion + ", matriculaprofesional=" + matriculaprofesional + ", toString()="
            + super.toString() + "]";
    }

}
