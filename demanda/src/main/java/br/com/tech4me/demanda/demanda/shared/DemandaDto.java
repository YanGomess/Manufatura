package br.com.tech4me.demanda.demanda.shared;

import br.com.tech4me.demanda.demanda.model.Manufatura;

public class DemandaDto {
    
    private String nomeDemanda;
    private String idManufatura;
    private Manufatura dadosManufatura;
    private Double valor;
    
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
    public Manufatura getDadosManufatura() {
        return dadosManufatura;
    }
    public void setDadosManufatura(Manufatura dadosManufatura) {
        this.dadosManufatura = dadosManufatura;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
