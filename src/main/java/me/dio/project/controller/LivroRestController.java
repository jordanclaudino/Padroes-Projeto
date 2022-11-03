package me.dio.project.controller;


import me.dio.project.model.Livro;
import me.dio.project.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroRestController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Iterable<Livro>> buscarTodos() {
        return ResponseEntity.ok(livroService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorCpf(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Livro> inserir(@RequestBody Livro livro) {
        livroService.inserir(livro);
        return ResponseEntity.ok(livro);
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro){
        livroService.atualizar(id, livro);
        return ResponseEntity.ok(livro);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Livro> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
