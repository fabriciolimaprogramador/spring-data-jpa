package br.com.plenasoftwares.projetospringdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.plenasoftwares.projetospringdatajpa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "select u from Usuario u where u.nome like %?1% ")
	public List<Usuario> buscarPorNome(String nome);
	
	@Query(value = "select u from Usuario u where u.nome = :paramnome ")
	public Usuario buscarPorNomeParam(@Param("paramnome") String paramnome);
	
	@Modifying
	@Transactional
	@Query("delete from Usuario u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional
	@Query("update Usuario u set u.email = ?1 where u.nome = ?2")
	public void updateEmailPorNome(String email, String nome);
	
	
	
}
