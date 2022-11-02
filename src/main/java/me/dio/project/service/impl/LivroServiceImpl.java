package me.dio.project.service.impl;


import me.dio.project.handler.ObjetoException;
import me.dio.project.model.Livro;
import me.dio.project.repository.AutorRepository;
import me.dio.project.repository.LivroRepository;
import me.dio.project.service.LivroService;
import me.dio.project.service.OpenLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private OpenLibraryService openLibraryService;

    @Override
    public Iterable<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    @Override
    public Livro buscarPorId(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.get();
    }

    @Override
    public void inserir(Livro livro) {
        salvarLivroComIsbn(livro);
    }



    @Override
    public void atualizar(Long id, Livro livro) {
        Optional<Livro> livroBd = livroRepository.findById(id);
        if (livroBd.isPresent()) {
            livroRepository.save(livro);
        } else throw new ObjetoException("livro");
    }

    @Override
    public void deletar(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        livro.ifPresent(value -> livroRepository.delete(value));
    }


    private void salvarLivroComIsbn(Livro livro) {
        String isbn = livro.getIsbn();
        Livro novoLivro = openLibraryService.consultarIsbn(isbn);
        novoLivro.setIsbn(isbn);
        livroRepository.save(novoLivro);
    }
}
