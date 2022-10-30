package me.dio.project.service;


import me.dio.project.model.Endereco;

public interface EnderecoService {

    Iterable<Endereco> buscarTodos();

    Endereco buscarPorCep(String cep);

    void deletar(String cep);

}
