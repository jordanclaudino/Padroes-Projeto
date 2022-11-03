package me.dio.project.resouce;

import java.util.List;

public class EmprestimoDto {
    private String cpfCliente;
    private Long idLivro;

    public EmprestimoDto() {
    }

    public EmprestimoDto(String cpfCliente, Long idLivro) {
        this.cpfCliente = cpfCliente;
        this.idLivro = idLivro;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }
}
