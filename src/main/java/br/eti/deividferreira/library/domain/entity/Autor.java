package br.eti.deividferreira.library.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Deivid Ferreira
 *
 */
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "autores", schema = "livro")
public class Autor extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Column(name = "nome", length = 90, nullable = false)
	private String nome;
	@Getter
	@Setter
	@Column(name = "sobrenome", length = 90, nullable = false)
	private String sobrenome;
	@Getter
	@Setter
	@Column(name = "aniversario")
	private LocalDate aniversario;
}
