package me.dio.project.service.impl;

import java.util.Optional;

import me.dio.project.handler.CampoObrigatorioException;
import me.dio.project.handler.ObjetoException;
import me.dio.project.model.Cliente;
import me.dio.project.model.Endereco;
import me.dio.project.repository.ClienteRepository;
import me.dio.project.repository.EnderecoRepository;
import me.dio.project.service.ClienteService;
import me.dio.project.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        if(cliente.getCpf() == null){
            throw new CampoObrigatorioException("cpf");
        }
        if(cliente.getNome() == null){
            throw new CampoObrigatorioException("nome");
        }
        if(cliente.getEndereco().getCep() == null){
            throw new CampoObrigatorioException("cep");
        }
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(String cpf, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(cpf);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        } else throw new ObjetoException("cliente");
    }

    @Override
    public void deletar(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
