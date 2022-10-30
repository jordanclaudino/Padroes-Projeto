package me.dio.project.service.impl;


import me.dio.project.model.Endereco;
import me.dio.project.repository.EnderecoRepository;
import me.dio.project.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Override
    public Iterable<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarPorCep(String cep) {
        Optional<Endereco> endereco = enderecoRepository.findById(cep);
        return endereco.get();
    }

    @Override
    public void deletar(String cep) {
        enderecoRepository.deleteById(cep);
    }
}
