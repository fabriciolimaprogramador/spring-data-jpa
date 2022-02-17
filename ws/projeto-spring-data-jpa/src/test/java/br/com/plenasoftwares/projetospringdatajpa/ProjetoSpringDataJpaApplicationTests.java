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
	void teste01() {
		System.out.println("Teste insert");
		Usuario arthur = new Usuario();
		arthur.setNome("Arthur");
		arthur.setIdade(12);
		arthur.setEmail("arthru@gmail.com");
		arthur.setLogin("arthur");
		arthur.setSenha("123");
		usuarioRepository.save(arthur);

		Usuario laura = new Usuario();
		laura.setNome("Laura");
		laura.setIdade(8);
		laura.setEmail("laura@gmail.com");
		laura.setLogin("laura");
		laura.setSenha("456");
		usuarioRepository.save(laura);

		Usuario laura2 = new Usuario();
		laura2.setNome("Laura");
		laura2.setIdade(8);
		laura2.setEmail("laura@gmail.com");
		laura2.setLogin("laura");
		laura2.setSenha("456");
		usuarioRepository.save(laura2);

		System.out.println("Usuario inserido");

	}

	@Test
	void teste02() {
		System.out.println("Teste buscar por id");
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(2L);
		Usuario usuario = usuarioOptional.get();
		System.out.println(usuario.toString());
	}

	@Test
	void teste03() {
		System.out.println("Teste Listar tudo");

		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}

	}
	
	@Test
	void teste04() {
		System.out.println("Teste alterar");
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(2L);
		Usuario usuario = usuarioOptional.get();
		System.out.println("Usuario atual " + usuario.toString());
		usuario.setNome("Celma Cristina");
		Usuario usuarioAlerado = usuarioRepository.save(usuario);
		System.out.println("Usuario alterado para " + usuarioAlerado.toString());

	}
	
	
	@Test
	void teste05() {
		System.out.println("Teste buscar por nome");
		List<Usuario> usuarios = usuarioRepository.buscarPorNome("L");
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
		
	}
	
	@Test
	void teste06() {
		System.out.println("Teste buscar por nome param");
		Usuario usuario = usuarioRepository.buscarPorNomeParam("Celma Cristina");
		System.out.println(usuario.toString());
		
	}
	
	@Test
	void teste07() {
		System.out.println("Teste delete por nome");
		usuarioRepository.deletePorNome("Laura");
		System.out.println("Laura deletada");
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}
		
	}
	
}
