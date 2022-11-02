package me.dio.project.repository;

import me.dio.project.model.Autor;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, String> {
}
