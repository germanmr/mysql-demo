package com.example.postgresdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "socios_dispositivos")
public class Dispositivo {

    @Id
    @GeneratedValue(generator = "clavecandidata_generator")
    @SequenceGenerator(name = "clavecandidata_generator", sequenceName = "clavecandidata_sequence", initialValue = 1)
    private Long clavecandidata;

    private String registrationid;

    // @JoinColumn(updatable = true, insertable = true, name = "codigoprofesion", referencedColumnName =
    // "socios_codigoProfesion"),
    // @JoinColumn(updatable = true, insertable = true, name = "matriculaprofesional", referencedColumnName =
    // "socios_matriculaprofesional")})

    // @NotBlank
    @OneToOne
    @JoinColumns({
        @JoinColumn(updatable = true, insertable = true, name = "codigoprofesion"),
        @JoinColumn(updatable = true, insertable = true, name = "matriculaprofesional")})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PrestadorPK prestadorPK;

    public Dispositivo() {
    }

    public Dispositivo(Long clavecandidata, String registrationid, PrestadorPK prestadorPK) {
        this.clavecandidata = clavecandidata;
        this.registrationid = registrationid;
        this.prestadorPK = prestadorPK;
    }

    public Long getClavecandidata() {
        return clavecandidata;
    }

    public void setClavecandidata(Long clavecandidata) {
        this.clavecandidata = clavecandidata;
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
        result = prime * result + ((clavecandidata == null) ? 0 : clavecandidata.hashCode());
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
        Dispositivo other = (Dispositivo) obj;
        if (clavecandidata == null) {
            if (other.clavecandidata != null)
                return false;
        } else if (!clavecandidata.equals(other.clavecandidata))
            return false;
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
        return "Dispositivo [clavecandidata=" + clavecandidata + ", registrationid=" + registrationid + ", prestadorPK=" + prestadorPK
            + ", toString()=" + super.toString() + "]";
    }

}
