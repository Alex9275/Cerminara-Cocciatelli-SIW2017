package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.modello.Amministratore;

public interface AmministratoreRepository  extends CrudRepository<Amministratore, Long>{
	Amministratore findByUsername(String username);
	
}
