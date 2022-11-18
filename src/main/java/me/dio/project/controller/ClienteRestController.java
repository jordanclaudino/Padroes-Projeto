package me.dio.project.controller;

import me.dio.project.model.Cliente;
import me.dio.project.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }
    @PostMapping("/create")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> atualizar(@PathVariable String cpf, @RequestBody Cliente cliente){
        clienteService.atualizar(cpf, cliente);
        return ResponseEntity.ok(cliente);
    }
}

