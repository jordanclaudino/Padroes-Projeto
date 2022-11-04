package me.dio.project.service.impl;

import me.dio.project.handler.ObjetoException;
import me.dio.project.model.Cliente;
import me.dio.project.model.Emprestimo;
import me.dio.project.model.Livro;
import me.dio.project.repository.ClienteRepository;
import me.dio.project.repository.EmprestimoRepository;
import me.dio.project.repository.LivroRepository;
import me.dio.project.resouce.EmprestimoDto;
import me.dio.project.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;
@Service
public class EmprestimoServiceImpl implements EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Emprestimo emprestarLivro(EmprestimoDto emprestimodto) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Emprestimo  emprestimo = Emprestimo.builder()
                .livro(livroRepository.findById(emprestimodto.getIdLivro()).orElseThrow(
                        () -> new ObjetoException("Livro")))
                .dataEmprestimo(formatter.format(System.currentTimeMillis()))
                .status("ABERTO")
                .cliente(clienteRepository.findById(emprestimodto.getCpfCliente()).orElseThrow(
                        ()  -> new ObjetoException("Cliente")
                ))
                .build();
        emprestimoRepository.save(emprestimo);
        emprestimo.getLivro().setEmprestado(true);
        return emprestimo;
    }

    @Override
    public void devolver(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(
                () -> new ObjetoException("Emprestimo")
        );
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        emprestimo.setDataDevolucao(formatter.format(System.currentTimeMillis()));
        emprestimo.setStatus("FECHADO");
        emprestimo.getLivro().setEmprestado(false);
    }

    @Override
    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(
                () -> new ObjetoException("Emprestimo")
        );
    }

    @Override
    public Emprestimo buscarPorCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Emprestimo buscarPorLivro(Livro livro) {
        return null;
    }
}
