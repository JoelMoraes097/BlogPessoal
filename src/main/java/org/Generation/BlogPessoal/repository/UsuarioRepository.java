package org.Generation.BlogPessoal.repository;

import java.util.Optional;

import org.Generation.BlogPessoal.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	public Optional<UsuarioModel> findByUsuario(String username);

	public Optional<UsuarioModel> findByNome(String string);

}
