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

import br.com.qty.domain.dto.UsuarioDTO;
import br.com.qty.manager.UsuarioManager;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioManager usuarioManager;

	@PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Salva um novo usuario")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody UsuarioDTO dto) {
		try {
			UsuarioDTO res = this.usuarioManager.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
