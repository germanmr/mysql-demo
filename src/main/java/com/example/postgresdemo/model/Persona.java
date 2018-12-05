package com.example.postgresdemo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "personas")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {

    @EmbeddedId
    private Documento documento;

    @JsonProperty("genero")
    @EnumValidator(enumClazz = Sexo.class, message = "Los valores posibles son M o F")
    private String genero;

    private Integer es_argentino;
    private Integer correo_electronico;
    private String foto_cara;
    private Integer id_localidad;

    @JsonCreator
    public Persona(@JsonProperty("documento") Documento documento, @JsonProperty("genero") String genero,
        @JsonProperty("es_argentino") Integer es_argentino, @JsonProperty("correo_electronico") Integer correo_electronico,
        @JsonProperty("foto_cara") String foto_cara, @JsonProperty("id_localidad") Integer id_localidad) {
        this.documento = documento;
        this.genero = genero;
        this.es_argentino = es_argentino;
        this.correo_electronico = correo_electronico;
        this.foto_cara = foto_cara;
        this.id_localidad = id_localidad;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEs_argentino() {
        return es_argentino;
    }

    public void setEs_argentino(Integer es_argentino) {
        this.es_argentino = es_argentino;
    }

    public Integer getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(Integer correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getFoto_cara() {
        return foto_cara;
    }

    public void setFoto_cara(String foto_cara) {
        this.foto_cara = foto_cara;
    }

    public Integer getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(Integer id_localidad) {
        this.id_localidad = id_localidad;
    }

}
