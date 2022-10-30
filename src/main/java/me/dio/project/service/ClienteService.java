package me.dio.project.service;

import me.dio.project.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorCpf(String cpf);
    void inserir(Cliente cliente);

    void atualizar(String cpf, Cliente cliente);

    void deletar(String cpf);
}
