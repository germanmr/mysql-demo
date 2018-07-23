package com.example.postgresdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DispositivoPK implements Serializable {

    @Column(name = "registrationid")
    private String registrationid;
    private PrestadorPK prestadorPK;

    public DispositivoPK() {
    }

    @JsonCreator
    public DispositivoPK(@JsonProperty("registrationid") String registrationid, @JsonProperty("prestadorPK") PrestadorPK prestadorPK) {
        this.registrationid = registrationid;
        this.prestadorPK = prestadorPK;
    }

    public String getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(String registrationid) {
        this.registrationid = registrationid;
    }

    public PrestadorPK getPrestadorPK() {
        return prestadorPK;
    }

    public void setPrestadorPK(PrestadorPK prestadorPK) {
        this.prestadorPK = prestadorPK;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prestadorPK == null) ? 0 : prestadorPK.hashCode());
        result = prime * result + ((registrationid == null) ? 0 : registrationid.hashCode());
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
        DispositivoPK other = (DispositivoPK) obj;
        if (prestadorPK == null) {
            if (other.prestadorPK != null)
                return false;
        } else if (!prestadorPK.equals(other.prestadorPK))
            return false;
        if (registrationid == null) {
            if (other.registrationid != null)
                return false;
        } else if (!registrationid.equals(other.registrationid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DispositivoPK [registrationid=" + registrationid + ", prestadorPK=" + prestadorPK + ", toString()=" + super.toString()
            + "]";
    }

}
