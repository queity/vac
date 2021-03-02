package br.com.qty.domain.dto;

import java.time.LocalDate;

import br.com.qty.domain.entity.AplicacaoVacina;

public class AplicacaoVacinaDTO {

	private Long id;
	private String nomeVacina;
	private Long idUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private LocalDate dataAplicacao;

	public AplicacaoVacinaDTO(AplicacaoVacina entidade) {
		this.id = entidade.getId();
		this.nomeVacina = entidade.getNomeVacina();
		this.idUsuario = entidade.getUsuario().getId();
		this.nomeUsuario = entidade.getUsuario().getNome();
		this.emailUsuario = entidade.getUsuario().getEmail();
		this.dataAplicacao = entidade.getDataAplicacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

}
