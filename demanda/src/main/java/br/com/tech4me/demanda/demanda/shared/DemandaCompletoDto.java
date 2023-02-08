package br.com.tech4me.demanda.demanda.shared;

import jakarta.validation.constraints.Positive;

public class DemandaCompletoDto {
    
    private String id;
    private String nomeDemanda;
    private String idManufatura;
    @Positive
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
