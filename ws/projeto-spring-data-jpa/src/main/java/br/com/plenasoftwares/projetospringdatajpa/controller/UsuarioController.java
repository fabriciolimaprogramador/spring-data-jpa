package br.com.plenasoftwares.projetospringdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plenasoftwares.projetospringdatajpa.dto.UsuarioDto;
import br.com.plenasoftwares.projetospringdatajpa.dto.UsuarioRespostaDto;
import br.com.plenasoftwares.projetospringdatajpa.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioRespostaDto> inserir(@RequestBody UsuarioDto usuarioDto) {
		UsuarioRespostaDto resposta = usuarioService.inserir(usuarioDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	}

	@GetMapping
	public ResponseEntity<List<UsuarioRespostaDto>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioRespostaDto> buscarPorId(@PathVariable Long id) {

		UsuarioRespostaDto usuario = usuarioService.buscarPorId(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioRespostaDto> alterar(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {

		UsuarioRespostaDto usuario = usuarioService.alterar(id, usuarioDto);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(usuario);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {

		boolean excluiu = usuarioService.excluir(id);
		if (excluiu) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();

	}
	

}
