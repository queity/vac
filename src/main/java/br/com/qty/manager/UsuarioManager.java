package br.com.qty.manager;

import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qty.domain.dto.UsuarioDTO;
import br.com.qty.domain.entity.Usuario;
import br.com.qty.repository.UsuarioRepository;

@Service
public class UsuarioManager {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO cadastrar(UsuarioDTO dto) {
		validarUsuario(dto);
		Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getDataNascimento());
		Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
		return new UsuarioDTO(usuarioSalvo);
	}

	private void validarUsuario(UsuarioDTO dto) {
		if (StringUtils.isEmpty(dto.getNome())) {
			throw new ValidationException("Nome é obrigatório");
		}
		if (StringUtils.isEmpty(dto.getEmail())) {
			throw new ValidationException("E-mail é obrigatório");
		}
		if (StringUtils.isEmpty(dto.getCpf())) {
			throw new ValidationException("CPF é obrigatório");
		}
		if (dto.getDataNascimento() == null) {
			throw new ValidationException("Data de nascimento é obrigatória");
		}
	}

}
