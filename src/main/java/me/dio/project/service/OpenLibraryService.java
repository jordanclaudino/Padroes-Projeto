package me.dio.project.service;

import me.dio.project.model.Autor;
import me.dio.project.model.Livro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "openlibrary", url ="https://openlibrary.org/")
public interface OpenLibraryService {

    @RequestMapping(method = RequestMethod.GET, value = "isbn/{isbn}.json")
    Livro consultarIsbn(@PathVariable("isbn") String isbn);

    @RequestMapping(method = RequestMethod.GET, value = "authors/{key}.json")
    Autor consultarKey(@PathVariable("key") String key);
}
