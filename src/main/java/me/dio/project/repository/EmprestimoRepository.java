package me.dio.project.repository;

import me.dio.project.model.Emprestimo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
}
