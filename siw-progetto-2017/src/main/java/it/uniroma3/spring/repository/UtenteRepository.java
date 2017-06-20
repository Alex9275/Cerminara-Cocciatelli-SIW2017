package it.uniroma3.spring.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.modello.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
	  Utente findByUsername(String username);
	  List<Utente> findAll();
}
