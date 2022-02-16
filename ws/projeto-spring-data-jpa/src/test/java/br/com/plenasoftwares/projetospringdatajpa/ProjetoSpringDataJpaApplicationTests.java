package br.com.plenasoftwares.projetospringdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.plenasoftwares.projetospringdatajpa.model.Usuario;
import br.com.plenasoftwares.projetospringdatajpa.repository.UsuarioRepository;

@SpringBootTest
class ProjetoSpringDataJpaApplicationTests {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void contextLoads() {
		System.out.println("Teste");
	}
	
	@Test
	void inserirUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Fabriico");
		
		usuarioRepository.save(usuario);
		
		
		System.out.println("Usuario inserido");
	}
	

}
