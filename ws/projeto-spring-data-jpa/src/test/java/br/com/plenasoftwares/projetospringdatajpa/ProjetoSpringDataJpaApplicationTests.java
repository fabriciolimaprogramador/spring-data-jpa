package br.com.plenasoftwares.projetospringdatajpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.plenasoftwares.projetospringdatajpa.model.Usuario;
import br.com.plenasoftwares.projetospringdatajpa.repository.UsuarioRepository;

@SpringBootTest
class ProjetoSpringDataJpaApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

//	@Test
//	void contextLoads() {
//		System.out.println("Teste");
//	}

	@Test
	void testeInsert() {
		System.out.println("Teste insert");
		Usuario fabricio = new Usuario();
		fabricio.setNome("Fabricio");
		fabricio.setIdade(48);
		fabricio.setEmail("fabricio@gmail.com");
		fabricio.setLogin("fabricio");
		fabricio.setSenha("123");
		usuarioRepository.save(fabricio);

		Usuario celma = new Usuario();
		celma.setNome("Celma");
		celma.setIdade(45);
		celma.setEmail("celma@gmail.com");
		celma.setLogin("celma");
		celma.setSenha("456");
		usuarioRepository.save(celma);

		System.out.println("Usuario inserido");

	}

	@Test
	void testeBuscarPorId() {
		System.out.println("Teste buscar por id");
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(2L);
		Usuario usuario = usuarioOptional.get();
		System.out.println(usuario.getNome());
	}

	@Test
	void testeListarTudo() {
		System.out.println("Teste Listar tudo");

		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario u : usuarios) {
			System.out.println("Nome do usuario: " + u.getNome());
		}

	}

}
