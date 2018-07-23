package com.example.postgresdemo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "socios_dispositivos")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dispositivo implements Serializable {

    @EmbeddedId
    private DispositivoPK dispositivoPK;

    public Dispositivo() {
    }

    @JsonCreator
    public Dispositivo(@JsonProperty("dispositivoPK") DispositivoPK dispositivoPK) {
        this.dispositivoPK = dispositivoPK;
    }

    public DispositivoPK getDispositivoPK() {
        return dispositivoPK;
    }

    public void setDispositivoPK(DispositivoPK dispositivoPK) {
        this.dispositivoPK = dispositivoPK;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dispositivoPK == null) ? 0 : dispositivoPK.hashCode());
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
        Dispositivo other = (Dispositivo) obj;
        if (dispositivoPK == null) {
            if (other.dispositivoPK != null)
                return false;
        } else if (!dispositivoPK.equals(other.dispositivoPK))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dispositivo [dispositivoPK=" + dispositivoPK + ", toString()=" + super.toString() + "]";
    }

}
