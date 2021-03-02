package br.com.qty.manager;

import java.util.Optional;

import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.qty.domain.dto.AplicacaoVacinaDTO;
import br.com.qty.domain.entity.AplicacaoVacina;
import br.com.qty.domain.entity.Usuario;
import br.com.qty.repository.AplicacaoVacinaRepository;
import br.com.qty.repository.UsuarioRepository;

@Service
public class AplicacaoVacinaManager {

	@Autowired
	private AplicacaoVacinaRepository aplicacaoVacinaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public AplicacaoVacinaDTO cadastrar(AplicacaoVacinaDTO dto) {
		validarAplicacaoVacina(dto);
		Optional<Usuario> usuario = this.usuarioRepository.findById(dto.getIdUsuario());
		if (!usuario.isPresent()) {
			throw new ValidationException("Usuário informado não existe");
		}
		AplicacaoVacina aplicacaoVacina = new AplicacaoVacina(dto.getNomeVacina(), usuario.get(),
				dto.getDataAplicacao());
		AplicacaoVacina aplicacaoVacinaSalvo = this.aplicacaoVacinaRepository.save(aplicacaoVacina);
		return new AplicacaoVacinaDTO(aplicacaoVacinaSalvo);
	}

	private void validarAplicacaoVacina(AplicacaoVacinaDTO dto) {
		if (StringUtils.isEmpty(dto.getNomeVacina())) {
			throw new ValidationException("Nome da vacina é obrigatório");
		}
		if (dto.getIdUsuario() == null) {
			throw new ValidationException("Usuário é obrigatório");
		}
		if (dto.getDataAplicacao() == null) {
			throw new ValidationException("Data da aplicação é obrigatória");
		}
	}

}
