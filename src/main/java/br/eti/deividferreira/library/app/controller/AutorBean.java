package br.eti.deividferreira.library.app.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.eti.deividferreira.library.domain.entity.Autor;
import br.eti.deividferreira.library.domain.repositories.AutorRepository;
import br.eti.deividferreira.library.domain.services.LibraryService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Deivid Ferreira
 *
 */
@Named
@ViewScoped
public class AutorBean extends AbstractBean {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Autor autor;

    @Getter
    private List<Autor> autors;

    @Inject
    private LibraryService libraryService;

    @Inject
    private AutorRepository authorRepository;

    /**
     * 
     */
    public void initializeListing() {
	this.viewState = ViewState.LISTING;
	this.autors = this.authorRepository.findAll();
    }

    /**
     * 
     * @param id
     * @param viewState
     */
    public void initializeForm(long id, String viewState) {

	this.viewState = ViewState.valueOf(viewState);

	switch (this.viewState) {
	case ADDING:
	    this.autor = new Autor();
	    break;
	case EDITING:
	    this.autor = this.libraryService.findAuthorById(id);
	    break;
	default:
	    break;
	}
    }

    /**
     * 
     * @return
     */
    public String save() {

	try {
	    this.autor = this.libraryService.save(this.autor);
	    return "listAutores.xhtml?faces-redirect=true";
	} catch (Exception ex) {
	    this.addError(false, "Nao foi possivel salvar o autor");
	    return null;
	}
    }

    /**
     * 
     * @return
     */
    public String update() {
	return "";
    }
}
