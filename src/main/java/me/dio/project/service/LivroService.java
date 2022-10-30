package me.dio.project.service;


import me.dio.project.model.Livro;

public interface LivroService {

    Iterable<Livro> buscarTodos();

    Livro buscarPorId(Long id);
    void inserir(Livro livro);

    void atualizar(Long id, Livro livro);

    void deletar(Long id);
}
