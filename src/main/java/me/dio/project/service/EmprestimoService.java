package me.dio.project.service;

import me.dio.project.model.Cliente;
import me.dio.project.model.Emprestimo;
import me.dio.project.model.Livro;
import me.dio.project.resouce.EmprestimoDto;

public interface EmprestimoService {

    Emprestimo emprestarLivro(EmprestimoDto emprestimodto);

    void devolver(Long id);

    Emprestimo buscarPorId(Long id);

    Emprestimo buscarPorCliente(Cliente cliente);

    Emprestimo buscarPorLivro(Livro livro);

}
