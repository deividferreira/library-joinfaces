/**
 * 
 */
package br.eti.deividferreira.library.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.eti.deividferreira.library.domain.entity.Autor;

/**
 * @author Deivid Ferreira
 *
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<Autor> findOptionalById(long id);
}
