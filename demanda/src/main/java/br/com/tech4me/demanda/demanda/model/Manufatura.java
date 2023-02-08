package br.com.tech4me.demanda.demanda.model;

import java.util.List;

public class Manufatura {
    
    private String servico;
    private List<String> produtos;
    private Double peso;
    
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
    public List<String> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
}
