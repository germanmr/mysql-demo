package com.example.postgresdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clave primaria de un {@link Prestador}
 * @author Fabricio Pizzichillo fpizzichillo
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestadorPK implements Serializable {

    @Column(name = "codigoprofesion")
    private Short codigorofesion;

    @Column(name = "matriculaprofesional")
    private Integer matriculaProfesional;

    public PrestadorPK() {
    }

    /**
     * Crea una instancia con los parámetros requeridos
     * @param codigoprofesion
     * @param matricula
     * @param libro
     * @param folio
     */
    @JsonCreator
    public PrestadorPK(@JsonProperty("codigoProfesion") Short codigoprofesion, @JsonProperty("matricula") Integer matricula) {
        this.codigorofesion = codigoprofesion;
        this.matriculaProfesional = matricula;
    }

    public Short getCodigoProfesion() {
        return codigorofesion;
    }

    public void setCodigoProfesion(Short codigoProfesion) {
        this.codigorofesion = codigoProfesion;
    }

    public Integer getMatriculaProfesional() {
        return matriculaProfesional;
    }

    public void setMatriculaProfesional(Integer matriculaProfesional) {
        this.matriculaProfesional = matriculaProfesional;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigorofesion == null) ? 0 : codigorofesion.hashCode());
        result = prime * result + ((matriculaProfesional == null) ? 0 : matriculaProfesional.hashCode());
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
        PrestadorPK other = (PrestadorPK) obj;
        if (codigorofesion == null) {
            if (other.codigorofesion != null)
                return false;
        } else if (!codigorofesion.equals(other.codigorofesion))
            return false;
        if (matriculaProfesional == null) {
            if (other.matriculaProfesional != null)
                return false;
        } else if (!matriculaProfesional.equals(other.matriculaProfesional))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PrestadorPK [codigoProfesion=" + codigorofesion + ", matriculaProfesional=" + matriculaProfesional + ", toString()="
            + super.toString() + "]";
    }

}
