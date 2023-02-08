package br.com.tech4me.demanda.demanda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("demandas")
public class Demanda {

    @Id
    private String id;
    private String nomeDemanda;
    private String idManufatura;
    private Double valor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeDemanda() {
        return nomeDemanda;
    }
    public void setNomeDemanda(String nomeDemanda) {
        this.nomeDemanda = nomeDemanda;
    }
    public String getIdManufatura() {
        return idManufatura;
    }
    public void setIdManufatura(String idManufatura) {
        this.idManufatura = idManufatura;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
