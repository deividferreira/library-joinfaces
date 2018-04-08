/**
 * 
 */
package br.eti.deividferreira.library.domain.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.eti.deividferreira.library.domain.entity.Autor;
import br.eti.deividferreira.library.domain.repositories.AutorRepository;

/**
 * @author Deivid Ferreira
 *
 */
@Component
@ApplicationScoped
public class LibraryService {

    @Inject
    private AutorRepository autorRepository;

    /**
     * 
     * @param autor
     * @return
     */
    @Transactional
    public Autor save(Autor autor) {
	return this.autorRepository.save(autor);
    }

    /**
     * 
     * @param idAutor
     * @return
     */
    public Autor findAuthorById(long idAuthor) {
	return this.autorRepository.findOptionalById(idAuthor)
		.orElseThrow(() -> new IllegalArgumentException("Nenhum autor localizado"));
    }
}
