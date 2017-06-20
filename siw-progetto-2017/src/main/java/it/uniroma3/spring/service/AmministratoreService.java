package it.uniroma3.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.spring.modello.Amministratore;
import it.uniroma3.spring.repository.AmministratoreRepository;

@Service
public class AmministratoreService {
	@Autowired
	private AmministratoreRepository amministratoreRepository;
	
    @Transactional
    public void add(final Amministratore amministratore) {
        this.amministratoreRepository.save(amministratore);
    }
    
    public Amministratore findByUsername(String username){
    	return this.amministratoreRepository.findByUsername(username);
    }
}
