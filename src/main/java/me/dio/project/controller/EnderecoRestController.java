package me.dio.project.controller;

import me.dio.project.model.Endereco;
import me.dio.project.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/endereco")
public class EnderecoRestController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Iterable<Endereco>> buscarTodos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoService.buscarPorCep(cep));
    }

    @DeleteMapping("/delete/{cep}")
    public ResponseEntity<Endereco> deletar(@PathVariable String cep){
        enderecoService.deletar(cep);
        return ResponseEntity.ok().build();
    }

}
