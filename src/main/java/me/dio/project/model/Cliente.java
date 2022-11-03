package me.dio.project.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    @ManyToOne
    private Endereco endereco;

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
