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

    public Cliente() {
    }

    public Cliente(String cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

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

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
