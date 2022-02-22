package br.com.expertpeticoes.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.expertpeticoes.curso.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

}
