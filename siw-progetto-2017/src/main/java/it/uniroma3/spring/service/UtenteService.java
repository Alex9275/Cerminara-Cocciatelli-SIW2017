package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.modello.Opera;
import it.uniroma3.spring.modello.Utente;
import it.uniroma3.spring.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;
	
    @Transactional
    public void add(final Utente utente) {
        this.utenteRepository.save(utente);
    }
    
    public Utente findByUserName(String username){
    	return this.utenteRepository.findByUsername(username);
    }
    
    public Iterable<Utente> findAll() {
		return this.utenteRepository.findAll();
	}
}
