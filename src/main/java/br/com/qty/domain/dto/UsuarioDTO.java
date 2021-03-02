package br.com.qty.domain.dto;

import java.time.LocalDate;

import br.com.qty.domain.entity.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.email = entidade.getEmail();
		this.cpf = entidade.getCpf();
		this.dataNascimento = entidade.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
