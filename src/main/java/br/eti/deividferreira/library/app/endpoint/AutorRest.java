package br.eti.deividferreira.library.app.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.deividferreira.library.domain.entity.Autor;
import br.eti.deividferreira.library.domain.repositories.AutorRepository;
import br.eti.deividferreira.library.domain.services.LibraryService;

/**
 * @author Deivid Ferreira
 *
 */
@RestController
@RequestMapping("/autores")
public class AutorRest {

    @Inject
    private LibraryService libraryService;

    @Inject
    private AutorRepository autorRepository;

    @PostMapping
    public Autor salvar(@Valid @RequestBody Autor autor) {
	return this.libraryService.save(autor);
    }

    @GetMapping
    public List<Autor> listAll() {
	return this.autorRepository.findAll();
    }

}
