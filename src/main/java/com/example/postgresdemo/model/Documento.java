package com.example.postgresdemo.model;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Documento {

    private Integer id_tipododocumento;
    private Integer numero_documento;

    public Documento() {
    }

    @JsonCreator
    public Documento(@JsonProperty("id_tipododocumento") Integer id_tipododocumento,
        @JsonProperty("numero_documento") Integer numero_documento) {
        this.id_tipododocumento = id_tipododocumento;
        this.numero_documento = numero_documento;
    }

}
