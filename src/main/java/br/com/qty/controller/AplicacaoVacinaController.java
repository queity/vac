package br.com.qty.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qty.domain.dto.AplicacaoVacinaDTO;
import br.com.qty.manager.AplicacaoVacinaManager;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/aplicacao-vacina")
public class AplicacaoVacinaController {

	@Autowired
	private AplicacaoVacinaManager aplicacaoVacinaManager;

	@PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Salva uma nova aplicação de vacina")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody AplicacaoVacinaDTO dto) {
		try {
			AplicacaoVacinaDTO res = this.aplicacaoVacinaManager.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
