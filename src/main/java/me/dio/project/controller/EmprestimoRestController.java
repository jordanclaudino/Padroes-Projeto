package me.dio.project.controller;

import me.dio.project.model.Cliente;
import me.dio.project.model.Emprestimo;
import me.dio.project.model.Livro;
import me.dio.project.resouce.EmprestimoDto;
import me.dio.project.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")

public class EmprestimoRestController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Emprestimo> incluirLivroNoEmprestimo(@RequestBody EmprestimoDto emprestimodto) {
        return ResponseEntity.ok(emprestimoService.emprestarLivro(emprestimodto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(emprestimoService.buscarPorId(id));
    }
    @GetMapping("/cliente/{cpfCliente}")
    public ResponseEntity<Emprestimo> buscarPorCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(emprestimoService.buscarPorCliente(cliente));
    }
    @GetMapping("/livro/{idLivro}")
    public ResponseEntity<Emprestimo> buscarPorLivro(@RequestBody Livro livro){
        return ResponseEntity.ok(emprestimoService.buscarPorLivro(livro));
    }
    @PatchMapping("/devolver/{id}")
    public ResponseEntity<Emprestimo> devolver(@PathVariable("idEmprestimo") Long id){
        return ResponseEntity.ok().build();
    }
}
