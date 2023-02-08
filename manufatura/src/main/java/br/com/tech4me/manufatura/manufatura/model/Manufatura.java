package br.com.tech4me.manufatura.manufatura.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("manufaturas")
public class Manufatura {

    @Id
    private String id;
    private String servico;
    private List<String> produtos;
    private Double peso;
    private Double valor;

    //O campo servico recebe valores como alvenaria, marcenaria, metalugia etc. Se refere ao tipo de servico da manufatura
    //Cada manufatura possui uma lista de produtos; por exemplo uma manufatura de marcenaria pode ter como produtos:
    // cadeira, mesa etc.
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
