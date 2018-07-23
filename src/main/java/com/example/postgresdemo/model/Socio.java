package com.example.postgresdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "socios")
public class Socio implements Serializable {

    @EmbeddedId
    private PrestadorPK prestadorPK;

    @Column(name = "nombreprofesional")
    private String name;

    public Socio() {
    }

    public Socio(PrestadorPK prestadorPK, String name) {
        this.prestadorPK = prestadorPK;
        this.name = name;
    }

    public PrestadorPK getPrestadorPK() {
        return prestadorPK;
    }

    public void setPrestadorPK(PrestadorPK prestadorPK) {
        this.prestadorPK = prestadorPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((prestadorPK == null) ? 0 : prestadorPK.hashCode());
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
        Socio other = (Socio) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (prestadorPK == null) {
            if (other.prestadorPK != null)
                return false;
        } else if (!prestadorPK.equals(other.prestadorPK))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Socio [prestadorPK=" + prestadorPK + ", name=" + name + ", toString()=" + super.toString() + "]";
    }

}
