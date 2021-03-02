package br.com.qty.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aplicacao_vacina")
public class AplicacaoVacina implements Serializable {

	private static final long serialVersionUID = -2697491549676869254L;

	@Id
	@Column(name = "id_aplicacao_vacina")
	private Long id;

	@Column(name = "nome_vacina", nullable = false)
	@NotBlank(message = "Nome é obrigatório")
	private String nomeVacina;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "data_aplicacao", nullable = false)
	@NotNull(message = "Data da aplicação é obrigatória")
	private LocalDate dataAplicacao;

	public Long getId() {
		return id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

}
