package br.com.plenasoftwares.projetospringdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.plenasoftwares.projetospringdatajpa.dto.UsuarioDto;
import br.com.plenasoftwares.projetospringdatajpa.dto.UsuarioRespostaDto;
import br.com.plenasoftwares.projetospringdatajpa.model.Usuario;
import br.com.plenasoftwares.projetospringdatajpa.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public UsuarioRespostaDto inserir(UsuarioDto usuarioDto) {

		Usuario usuario = converter(usuarioDto);

		Usuario usuarioInserido = usuarioRepository.save(usuario);

		return converter(usuarioInserido);
	}

	public UsuarioRespostaDto buscarPorId(Long id) {

		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			return converter(usuario);
		}

		return null;
	}

	public List<UsuarioRespostaDto> listar() {

		List<Usuario> usuarios = usuarioRepository.findAll();

		if (usuarios == null) {
			return null;
		}
		
		List<UsuarioRespostaDto> lista = new ArrayList<>(); 
		
		for (Usuario usuario : usuarios) {
			UsuarioRespostaDto usuarioRespostaDto = converter(usuario);
			lista.add(usuarioRespostaDto);
		}
		return lista;
		
	}
	
	@Transactional
	public UsuarioRespostaDto alterar(Long id, UsuarioDto usuarioDto) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if(!usuarioOptional.isPresent()) {
			return null;
		}

		Usuario usuarioAtual = usuarioOptional.get();
		
		Usuario usuario = converter(usuarioDto, usuarioAtual);

		Usuario usuarioAlterado = usuarioRepository.save(usuario);
		
		return converter(usuarioAlterado);
	}
	
	@Transactional
	public boolean excluir(Long id) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if(!usuarioOptional.isPresent()) {
			return false;
		}

		usuarioRepository.deleteById(id);
		return true;

	}
	
	private UsuarioRespostaDto converter(Usuario usuario) {
		UsuarioRespostaDto usuarioRespostaDto = new UsuarioRespostaDto();
		usuarioRespostaDto.setId(usuario.getId());
		usuarioRespostaDto.setNome(usuario.getNome());
		usuarioRespostaDto.setIdade(usuario.getIdade());
		usuarioRespostaDto.setEmail(usuario.getEmail());
		usuarioRespostaDto.setLogin(usuario.getLogin());
		usuarioRespostaDto.setSenha(usuario.getSenha());
		return usuarioRespostaDto;
		
	}
	
	private Usuario converter(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setIdade(usuarioDto.getIdade());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setLogin(usuarioDto.getLogin());
		usuario.setSenha(usuarioDto.getSenha());
		return usuario;
	}

	private Usuario converter(UsuarioDto usuarioDto, Usuario usuarioAtual) {
		Usuario usuario = converter(usuarioDto);
		usuario.setId(usuarioAtual.getId());
		return usuario;
	}

}
