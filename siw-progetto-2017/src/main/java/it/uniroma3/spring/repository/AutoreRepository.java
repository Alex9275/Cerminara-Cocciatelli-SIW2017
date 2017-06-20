package it.uniroma3.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.modello.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long>{
	
	  List<Autore> findAll();
	  List<Autore> findByCognome(String cognome);
	  List<Autore> findByNazionalita(String nazionalita);
	  List<Autore> findByDataNascita(Date dataNascita);
	  List<Autore> findByDataMorte(Date dataMorte);
}
