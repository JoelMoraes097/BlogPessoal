package org.Generation.BlogPessoal.test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.Generation.BlogPessoal.model.UsuarioModel;
import org.Generation.BlogPessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	private @Autowired UsuarioRepository repository;
	
	@BeforeAll
	void start() {
		repository.save(new UsuarioModel("Alan", "alanminecraft", "134652"));
		repository.save(new UsuarioModel("Murilo", "murilocouto", "134652"));
		repository.save(new UsuarioModel("Gustavo", "gugugalo", "134652"));
		repository.save(new UsuarioModel("Joel", "joelirmao", "134652"));
		repository.save(new UsuarioModel("Otavio", "tavinben10", "134652"));
	}
	
	@Test
	@DisplayName("Search valid usuario!")
	void searchUsuarioValidReturnObjectValid() {
		
		//When
		UsuarioModel user = repository.findByUsuario("murilocouto").get();
		
		//Then
		assertTrue(user.getNome().equals("Murilo"));
	}
	
	@Test
	@DisplayName("Search invalid Name!")
	void searchNameInvalidReturnOptionalEmpty() {
		
		//When
		Optional<UsuarioModel> optional = repository.findByNome("");
		
		//Then
		assertTrue(optional.isEmpty());
	}
}