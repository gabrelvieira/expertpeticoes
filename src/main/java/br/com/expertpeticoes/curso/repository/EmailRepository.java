package br.com.expertpeticoes.curso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.expertpeticoes.curso.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
	
	@Query(value = "SELECT e FROM Email e WHERE e.email = :email")
	public Optional<Email> findByEmail(String email);
	
	@Query(value = "SELECT e FROM Email e WHERE e.propaganda = true")
	public List<Email> findEmailGratis();
}
